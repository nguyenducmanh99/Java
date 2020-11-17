package com.vti.backend.datalayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Manager;
import com.vti.entity.User;

public interface IUserRepository {
	List<User> getListUsers() throws SQLException, ClassNotFoundException, IOException;
	
	User login(String email, String password) throws Exception;
	
	void createUser(String name) throws SQLException, ClassNotFoundException, IOException;
	
	public List<Manager> getListManager() throws SQLException, ClassNotFoundException, IOException;
	
	boolean isUserNameExits(String name) throws SQLException, ClassNotFoundException, IOException;
	
	boolean isUserIDExits(int id) throws SQLException, ClassNotFoundException, IOException;
}
