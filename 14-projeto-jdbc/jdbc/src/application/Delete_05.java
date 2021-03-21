package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Delete_05 {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DB.getConnection();
	
			String sql = "DELETE FROM department WHERE Id = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, 6);
		
			int rowsAffected = statement.executeUpdate();
			
			
			System.out.println("Done. " + rowsAffected + " rows affected.");			
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(statement);
			DB.closeConnection();
		}
	}
	
}
