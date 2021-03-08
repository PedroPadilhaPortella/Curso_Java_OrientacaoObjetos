package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJdbc implements SellerDAO {
	
	private Connection connection;
	
	public SellerDaoJdbc(Connection connection) {
		this.connection = connection;
	}

	
	@Override
	public void insert(Seller seller)
	{
		PreparedStatement statement = null;
		
		try {
			String sql = "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, seller.getName());
			statement.setString(2, seller.getEmail());
			statement.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
			statement.setDouble(4, seller.getBaseSalary());
			statement.setInt(5, seller.getDepartment().getId());
			
			int rowsAffected = statement.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet resultSet = statement.getGeneratedKeys();
				
				if(resultSet.next()) {
					int id = resultSet.getInt(1);
					seller.setId(id);
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
	public void update(Seller seller)
	{
		PreparedStatement statement = null;
		
		try {
			String sql = "UPDATE seller SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? WHERE Id = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, seller.getName());
			statement.setString(2, seller.getEmail());
			statement.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
			statement.setDouble(4, seller.getBaseSalary());
			statement.setInt(5, seller.getDepartment().getId());
			statement.setInt(6, seller.getId());
			
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
			String sql = "DELETE FROM seller WHERE Id = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
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
	public Seller findById(Integer id)
	{
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT seller.*, department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE seller.Id = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Department department = instantiateDepartment(resultSet);
				Seller seller = instantiateSeller(resultSet, department);
				return seller;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(statement);
			DB.closeResultSet(resultSet);
		}
	}

	
	@Override
	public List<Seller> findAll()
	{
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id ORDER BY Name";
			
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			List<Seller> sellers = new ArrayList<Seller>();
			Map<Integer, Department> map = new HashMap<>();
			
			while(resultSet.next()) {
				Department dep = map.get(resultSet.getInt("DepartmentId"));
				
				if(dep == null) {
					dep = instantiateDepartment(resultSet);
					map.put(resultSet.getInt("DepartmentId"), dep);
				} 
				
				Seller seller = instantiateSeller(resultSet, dep);
				sellers.add(seller);
			}
			
			return sellers;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(statement);
			DB.closeResultSet(resultSet);
		}
	}
	
	
	@Override
	public List<Seller> findByDepartment(Department department)
	{
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id WHERE DepartmentId = ? ORDER BY Name";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, department.getId());
			resultSet = statement.executeQuery();
			
			List<Seller> sellers = new ArrayList<Seller>();
			Map<Integer, Department> map = new HashMap<>();
			
			while(resultSet.next()) {
				Department dep = map.get(resultSet.getInt("DepartmentId"));
				
				if(dep == null) {
					dep = instantiateDepartment(resultSet);
					map.put(resultSet.getInt("DepartmentId"), dep);
				} 
				
				Seller seller = instantiateSeller(resultSet, dep);
				sellers.add(seller);
			}
			
			return sellers;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(statement);
			DB.closeResultSet(resultSet);
		}
	}
	
	
	
	private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
		Department department = new Department();
		department.setId(resultSet.getInt("DepartmentId"));
		department.setName(resultSet.getString("DepName"));
		return department;
	}
	
	
	private Seller instantiateSeller(ResultSet resultSet, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(resultSet.getInt("Id"));
		seller.setName(resultSet.getString("Name"));
		seller.setEmail(resultSet.getString("Email"));
		seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
		seller.setBirthDate(resultSet.getDate("BirthDate"));
		seller.setDepartment(department);
		return seller;
	}
}