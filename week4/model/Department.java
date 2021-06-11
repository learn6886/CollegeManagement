package com.main.java.week4.model;

/**
 * This is Department POJO class.Defines Student fields and getter-setter
 * methods, constructors.
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 */
public class Department {
	private int deptId;
	private String dept;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Department() {
	}

	public Department(int deptId, String dept) {
		super();
		this.deptId = deptId;
		this.dept = dept;
	}

}
