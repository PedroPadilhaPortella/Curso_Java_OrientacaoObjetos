package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection connection = null;
	
	
	public static Connection getConnection()
	{
		try {
			if(connection == null) {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				connection = DriverManager.getConnection(url, props);
				System.out.println("Conectando...");
			}
			return connection;
		}
		catch (SQLException e) {
				throw new DbException(e.getMessage());
		}
	}
	
	
	public static void closeConnection() {
		try {
			if(connection != null)
				connection.close();
			System.out.println("Desconectando...");
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	

	private static Properties loadProperties()
	{
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement statement) {
		try {
			if(statement != null)
				statement.close();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeResultSet(ResultSet resultSet) {
		try {
			if(resultSet != null)
				resultSet.close();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}
