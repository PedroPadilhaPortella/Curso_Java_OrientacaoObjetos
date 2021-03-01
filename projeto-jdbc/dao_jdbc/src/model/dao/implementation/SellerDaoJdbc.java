package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
	public void insert(Seller seller) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void update(Seller seller) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT seller.*, department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE seller.Id = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Department department = new Department();
				department.setId(resultSet.getInt("DepartmentId"));
				department.setName(resultSet.getString("DepName"));
				
				Seller seller = new Seller();
				seller.setId(resultSet.getInt("Id"));
				seller.setName(resultSet.getString("Name"));
				seller.setEmail(resultSet.getString("Email"));
				seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
				seller.setBirthDate(resultSet.getDate("BirthDate"));
				seller.setDepartment(department);
				
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
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}