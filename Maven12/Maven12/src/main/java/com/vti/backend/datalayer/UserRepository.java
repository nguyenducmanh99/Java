package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.vti.Utils.JdbcUtils;
import com.vti.entity.Manager;
import com.vti.entity.Role;
import com.vti.entity.User;

public class UserRepository implements IUserRepository {
	private JdbcUtils jdbcUltils;
	private Connection connection;

	public UserRepository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUltils = new JdbcUtils();
	}
// Lay danh sach
	public List<User> getListUsers() throws SQLException, ClassNotFoundException, IOException {
		List<User> users = new ArrayList<>();

		try {
			// get connect
			connection = jdbcUltils.getConnection();

			// Step 3: Create a statment object
			Statement statement = connection.createStatement();

			// Step 4: Execute query
			String listUser = "SELECT * FROM QLUser.user";
			ResultSet resultSet = statement.executeQuery(listUser);

			// Step 5: Handling result set
			while (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				Role role = Role.valueOf(resultSet.getString("Role"));

				User user = new User(userId, fullName, email, password, role);
				users.add(user);

			}
			return users;
		} finally {
			// Step 6: Close connection
			connection.close();
		}
	}
// Dang nhap	
	public User login(String email, String password) throws Exception {

		try {

			// step 2: get connect
			connection = jdbcUltils.getConnection();

			// Step 3: Create a statement object

			String sql = "SELECT * FROM QLUser.User " + "WHERE Email = ? AND Password = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			// Step 4: Execute Query

			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result
			if (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				Role role = Role.valueOf(resultSet.getString("Role").toUpperCase());

				User user = new User(userId, fullName, email, password, role);
				return user;
			} else {
				throw new Exception("Tai khoan hoac mat khau sai!");
			}

		} finally {
			connection.close();
		}

	}
	// Tao user
	public void createUser(String name) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = jdbcUltils.getConnection();
		String sql = " INSERT INTO `User`         (`name`,   `author_ID` )"
				+ "VALUE                           (?       ,        8    )";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.executeUpdate();
		jdbcUltils.disconnect();
	}
	
	public List<Manager> getListManager() throws SQLException, ClassNotFoundException, IOException {
		List<Manager> managers = new ArrayList<>();

		try {
			// get connect
			connection = jdbcUltils.getConnection();

			// Step 3: Create a statment object
			Statement statement = connection.createStatement();

			// Step 4: Execute query
			String listManager = "SELECT *FROM `User` WHERE Role='MANAGER'";
			ResultSet resultSet = statement.executeQuery(listManager);

			// Step 5: Handling result set
			while (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				Role role = Role.valueOf(resultSet.getString("Role"));
				int ExpInYear = (5) ;
				Manager manager = new Manager (ExpInYear, password, password, password, ExpInYear);
				managers.add(manager);

			}
			return managers;
		} finally {
			// Step 6: Close connection
			connection.close();
		}
	}
	
	
	
	
	public boolean isUserNameExits(String name) throws SQLException, ClassNotFoundException, IOException {
		try {

			// step 2: get connect
			connection = jdbcUltils.getConnection();

			// Step 3: Create a statement object

			String sql = "SELECT 1 FROM `User` " + " WHERE FullName = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, name);

			// Step 4: Execute Query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set

			if (resultSet.next()) {

				return true;
			}

			return false;
		} finally {
			connection.close();
		}

	}
	public boolean isUserIDExits(int id) throws SQLException, ClassNotFoundException, IOException {
		try {

			// step 2: get connect
			connection = jdbcUltils.getConnection();

			// Step 3: Create a statement object

			String sql = "SELECT 1 FROM `User` " + " WHERE UserID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute Query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set

			if (resultSet.next()) {

				return true;
			}

			return false;
		} finally {
			connection.close();
		}

	}
	
}
