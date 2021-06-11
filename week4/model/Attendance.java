package com.main.java.week4.model;

/**
 * This is Attendance POJO class.Defines Student fields and getter-setter
 * methods, constructors.
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 */

public class Attendance {
	private int rollNo;
	private String studName;
	private String course;
	private String percentage;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public Attendance() {
	}

	public Attendance(int rollNo, String studName, String course, String percentage) {
		super();
		this.rollNo = rollNo;
		this.studName = studName;
		this.course = course;
		this.percentage = percentage;
	}

}
