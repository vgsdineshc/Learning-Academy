package com.JdbcConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/learneracademy";
	public static final String UN = "root";
	public static final String PWD = "123456";
	public static Connection con = null;
	
	public static Connection getDBConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection(DB_URL, UN, PWD);
		if(con!=null) {
			System.out.println("connection is established");
		}
		else {
			System.out.println("check the details of the connection");
		}
		
		return con;
	}
	
	public static void closeDbConnection() throws SQLException
	{
		try {
			
		} catch (Exception e) {

		}
		finally {
			if (con != null)
			{
				con.close();
				System.out.println("Established connection Closed");
			}
		}
	}
	
	
}
