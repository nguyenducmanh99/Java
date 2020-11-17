package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class Function {
	private UserController userController;

	public Function() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userController = new UserController();
	}

	public void getListUser() throws ClassNotFoundException, SQLException, IOException {
		List<User> users = userController.getListUsers();
		System.out.printf("%-15s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password");
		for (User user : users) {
			System.out.printf("%-15s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),
					"*********");
		}
	}
	
	public void getListManagers() throws ClassNotFoundException, SQLException, IOException {
		List<Manager> managers = userController.getListManagers();
		System.out.printf("%-15s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password");
		for (Manager manager : managers) {
			System.out.printf("%-15s %-25s %-25s %-25s\n", manager.getId(), manager.getEmail(), manager.getFullName(),
					"*********");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public User login() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Mời bạn nhập vào Email của account: ");
			String email = ScannerUtils.inputEmail("Email chưa đúng định dạng\n");

			System.out.print("Mời bạn nhập password: ");
			String password = ScannerUtils
					.inputPassword("Password phai dai tu 6--> 12 ki tu va co it nhat 1 chu viet hoa!");
			try {
				return userController.login(email, password);

			} catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
			}
		}
	}
	public void createUser() throws SQLException, ClassNotFoundException, IOException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Moi ban nhap vao ten: ");
	String name1 = ScannerUtils.inputString("Ban khong duoc de trong!");
	try {
		userController.createUser(name1);
		System.out.println("Tao thanh cong");
	} catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Tao that bai!");
	  }
	}
}