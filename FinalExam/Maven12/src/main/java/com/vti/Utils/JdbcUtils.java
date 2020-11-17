package com.vti.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	private Connection connection;

	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		if (connection == null || connection.isClosed()) {
			String url = ("jdbc:mysql://localhost:3306/QLUser?autoReconnect=true&useSSL=false&characterEncoding=latin1");
			String username = "root";
			String password = "root";

			// Register the drive class with DriveManager
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Get a Database Connection
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