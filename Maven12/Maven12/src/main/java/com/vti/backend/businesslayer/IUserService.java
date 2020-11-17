package com.vti.backend.businesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Manager;
import com.vti.entity.User;

public interface IUserService {
	List<User> getListUsers() throws SQLException, ClassNotFoundException, IOException;
	void createUser(String name) throws Exception;
	public List<Manager> getListManagers() throws SQLException, ClassNotFoundException, IOException;
	boolean isUserNameExits(String name) throws SQLException, ClassNotFoundException, IOException;
	User login(String email, String password) throws Exception;
	boolean isUserIDExits(int id) throws SQLException, ClassNotFoundException, IOException;
}
