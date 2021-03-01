package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Select_02 {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DB.getConnection();
	
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from department");
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("Id") + ": " + resultSet.getString("Name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(resultSet);
			DB.closeStatement(statement);
			DB.closeConnection();
		}
	}
	
}
