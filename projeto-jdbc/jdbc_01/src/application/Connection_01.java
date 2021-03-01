package application;

import java.sql.Connection;

import db.DB;

public class Connection_01 {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Connection conexao = DB.getConnection();
		DB.closeConnection();
	}
	
}
