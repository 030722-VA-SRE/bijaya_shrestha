package com.revature.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection con;

	public static Connection getConnection() throws SQLException {
		
		
		// set up url jdbc:postgresql://[db-url]:5432/[db-name]";
//		String url = "jdbc:postgresql://database-1.cllvqmegtmuc.us-east-1.rds.amazonaws.com:5432/postgres";
//		String username = "postgres";
//		String password = "elephant";
		
		
		String url = System.getenv("DB_URL_JAVALIN");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS"); 
		
 // pg_ctl start and pg_ctl stop to start and shutdown the database in gitbash.
		
		// if con exists, return con, else instantiate con
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}
}
