package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection
 * 
 * Version 1.0
 * 
 * Date: 03/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 03/05/2017		TinLQ			Create
 */
public class DBConnection {
	/**
	 * connect to database
	 * @return connection
	 */
	public static Connection getConnect(){
		// url to connect database
		String url = "jdbc:sqlserver://localhost:1433;databaseName=AVX";
		//user name to connect database
		String userName = "sa";
		//password to connect database
		String password = "abc@1234";
		Connection connection = null;
		//start connect to database
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			;
		} catch (ClassNotFoundException e) {
			;
		}finally {
			;
		}
		//return connection
		return connection;
	}
	
	/**
	 * disConnect(): close connection with database
	 */
	public static void disConnect() {
		try {
			if (getConnect() != null)
				getConnect().close();
		} catch (SQLException e) {
			;
		}
	}
}
