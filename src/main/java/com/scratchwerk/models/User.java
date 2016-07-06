package com.scratchwerk.models;

import org.springframework.data.annotation.Id;

public class User {

	public final static int USER_ROLE_STUDENT = 1;
	public final static int USER_ROLE_PARENT = 2;
	public final static int USER_ROLE_MENTOR = 3;
	public final static int USER_ROLE_ADMIN = 4;
	
	@Id
    private String id;
	
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String suffix;
	private String password;
	private int roleId;
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	
	
}
