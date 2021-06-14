package com.revature.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
	//ok it gets the properties file.
	private static Connection conn = null;
	public static Connection getConnection() {
		try {
			if(conn == null) {
				Class.forName("org.postgresql.Driver");
				Properties props = new Properties();
				InputStream input = JDBCConnection.class.getClassLoader()
						.getResourceAsStream("connections.properties");
			props.load(input);
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			conn = DriverManager.getConnection(url,username,password);
			return conn;
			} else {
				return conn;
			}
		}catch(SQLException | IOException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
