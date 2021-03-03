package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class DepartmentDaoJdbc implements DepartmentDAO {

	private Connection connection;
	
	public DepartmentDaoJdbc(Connection connection) {
		this.connection = connection;
	}
	
	private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
		Department department = new Department();
		department.setId(resultSet.getInt("Id"));
		department.setName(resultSet.getString("Name"));
		return department;
	}
	
	@Override
	public void insert(Department department)
	{
		PreparedStatement statement = null;
		
		try {
			String sql = "INSERT INTO department (Name) VALUE (?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, department.getName());
			
			int rowsAffected = statement.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet resultSet = statement.getGeneratedKeys();
				
				if(resultSet.next()) {
					int id = resultSet.getInt(1);
					department.setId(id);
				}
				DB.closeResultSet(resultSet);
			} else {
				throw new DbException("Unexpected error! No rows affected.");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(statement);
		}
		
	}

	@Override
	public void update(Department department)
	{
		PreparedStatement statement = null;
		
		try {
			String sql = "UPDATE department SET Name = ? WHERE Id = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, department.getName());
			statement.setInt(2, department.getId());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(statement);
		}
	}

	@Override
	public void deleteById(Integer id)
{
		PreparedStatement statement = null;
		
		try {
			String sql = "DELETE FROM department WHERE Id = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(statement);
		}
	}

	@Override
	public Department findById(Integer id)
	{
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT department.* FROM department WHERE Id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Department department = instantiateDepartment(resultSet);
				return department;
			}
			
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(statement);
		}
	}

	@Override
	public List<Department> findAll()
	{
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT department.* FROM department ORDER BY department.Name";
			
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			List<Department> departments = new ArrayList<Department>();
			
			while(resultSet.next()) {
				Department department = instantiateDepartment(resultSet);
				departments.add(department);
			}
			
			return departments;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(statement);
		}
	}

}
