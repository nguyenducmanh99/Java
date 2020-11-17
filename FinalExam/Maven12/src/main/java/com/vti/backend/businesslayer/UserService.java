package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class UserService  implements IUserService  {
	private IUserRepository userRepository;

	public UserService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userRepository = new UserRepository();
	}

	public List<User> getListUsers() throws SQLException, ClassNotFoundException, IOException {
		return userRepository.getListUsers();
	}

	public  void createUser(String name) throws Exception {
		if (isUserNameExits(name)){
			throw new Exception("User_Name exist!");
		}
		userRepository.createUser(name);
	       
	 }

	public List<Manager> getListManagers() throws SQLException, ClassNotFoundException, IOException {
		return userRepository.getListManager();
	}

	public boolean isUserNameExits(String name) throws SQLException, ClassNotFoundException, IOException {
		return userRepository.isUserNameExits(name);
	}

	public User login(String email, String password) throws Exception {
		return userRepository.login(email, password);
	}
	public boolean isUserIDExits(int id) throws SQLException, ClassNotFoundException, IOException{
		return userRepository.isUserIDExits(id);
	}

}
