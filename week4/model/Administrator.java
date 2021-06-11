package com.main.java.week4.model;

/**
 * This is Administrator POJO class.Defines Student fields and getter-setter
 * methods, constructors.
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 */

public class Administrator {
	private int adminId;
	private String adminName;
	private String password;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Administrator() {
	}

	public Administrator(int adminId, String adminName, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
	}
	
	public Administrator(String adminName, String password) {
		super();
		this.adminName = adminName;
		this.password = password;
	}

}
