package com.masai.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbutils {

//	static final String url;
//	static final String username;
//	static final String password;
	
	static {
//		reading credentials from property file
//		ResourceBundle bundle = ResourceBundle.getBundle("dbdetails");
//		url = bundle.getString("url");
//		username = bundle.getString("username");
//		password = bundle.getString("password");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e1) {
			System.err.println("fatal error,bye bye");
			System.exit(1);
		}
	}
	
	static Connection connectTodatabase() throws SQLException {
		
		String url = "jdbc:mysql://localhost/cw_project";
		String username = "root";
		String password = "root";
		
		return DriverManager.getConnection(url,username,password);
		
	}
	
	static void closeConnection(Connection conn) throws SQLException {
		
		if(conn != null) {
			
			conn.close();
			
		}
		
	}
	
	static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0)?true:false;
	}
	
	
}
