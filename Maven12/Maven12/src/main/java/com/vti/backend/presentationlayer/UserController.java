package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.UserService;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class UserController {

	private com.vti.backend.businesslayer.IUserService userService;

	public UserController() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userService = new UserService();
	}

	public List<User> getListUsers() throws SQLException, ClassNotFoundException, IOException {

		return userService.getListUsers();
	}

	public void createUser(String name) throws Exception {
		if (name == null || name.length() > 20 || name.length() < 6) {
			throw new Exception("Ten group phai lon hon 6 va nho hon 20");
		}
		userService.createUser(name);
	}
	

	public List<Manager> getListManagers() throws SQLException, ClassNotFoundException, IOException{
		return userService.getListManagers();
	}

	public boolean isUserNameExits(String name) throws SQLException, ClassNotFoundException, IOException {
		return userService.isUserNameExits(name);
	}

	public User login(String email, String password) throws Exception {
		return userService.login(email, password);
	}
	
	public boolean isUserIdExits(int id) throws SQLException, ClassNotFoundException, IOException {
		return userService.isUserIDExits(id);
	}
}
