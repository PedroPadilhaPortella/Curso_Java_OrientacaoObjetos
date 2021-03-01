package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Update_04 {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DB.getConnection();
	
			String sql = "UPDATE seller SET BaseSalary = BaseSalary + ? WHERE DepartmentId = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setDouble(1, 400.0);
			statement.setInt(2, 5);
			
			int rowsAffected = statement.executeUpdate();
			
			
			System.out.println("Done. " + rowsAffected + " rows affected.");			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(statement);
			DB.closeConnection();
		}
	}
	
}
