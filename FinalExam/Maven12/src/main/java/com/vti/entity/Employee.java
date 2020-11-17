package com.vti.entity;

public class Employee extends User{
	private String ProSkill;
	private  int   projectID;
	public Employee(int id, String fullName, String email, String password, String ProSkill) {
		super(id, fullName, email, password, Role.USER);
		this.ProSkill = ProSkill;
		this.projectID=projectID;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	public void setprojectID(int projectID) {
		projectID = projectID;
	}
	
	
	@Override
	public String toString() {
		return "Employee [ProSkill=" + ProSkill + ", getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getRole()=" + getRole()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
}
