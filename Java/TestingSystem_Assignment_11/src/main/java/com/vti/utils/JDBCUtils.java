package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	private Connection connection;
	Properties properties = new Properties();

	public Connection getConnection() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		if (connection == null || connection.isClosed()) {
		properties.load(new FileInputStream("src/main/resource/database.properties"));
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");
		Class.forName(driver);

		connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	public void disconnect() throws SQLException {
		if (connection != null && connection.isClosed()) {
			connection.close();
		}
	}
}