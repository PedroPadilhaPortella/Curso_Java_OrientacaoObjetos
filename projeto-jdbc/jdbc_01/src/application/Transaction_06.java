package application;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Transaction_06 {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); //torna as operacoes não automáticas
			statement = connection.createStatement();
			
			int x = 1;
			int rows1 = statement.executeUpdate("UPDATE seller SET BaseSalary = 9999 WHERE DepartmentId = 1");
			if(x < 2)    throw new SQLException("Fake error throwed to Test Transaction.");
			int rows2 = statement.executeUpdate("UPDATE seller SET BaseSalary = 7777 WHERE DepartmentId = 2");
			
			connection.commit(); //commit da execucao dos comandos
			
			System.out.println("Rows 1: " + rows1 + ", rows 2: " + rows2);
			
		}
		catch(SQLException e) {
			try {
				connection.rollback();	
				throw new DbException("Transation rollwed back! Caused by : " + e.getMessage());
			} catch(SQLException err) {
				throw new DbException("Error trying to rollback! caused by :" + err.getMessage());
			}
		}
		finally {
			DB.closeStatement(statement);
			DB.closeConnection();
		}

	}

}
