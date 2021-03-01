package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Insert_03 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DB.getConnection();
	
			String sql = "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, "Pedro Portella");
			statement.setString(2, "pedro.kadjin.sg@gmail.com");
			statement.setDate(3, new Date(sdf.parse("10/06/2001").getTime()));
			statement.setDouble(4, 1600.0);
			statement.setInt(5, 5);

			
			sql = "INSERT INTO department (Name) VALUES ('D1'), ('D2')";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = statement.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet resultSet = statement.getGeneratedKeys();
				while(resultSet.next()) {
					int id = resultSet.getInt(1);
					System.out.println("Done. " + rowsAffected + " rows affected.\nId = " + id);			
				}
			} else {
				System.out.println("No rows affected.");
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(statement);
			DB.closeConnection();
		}
	}
	
}
