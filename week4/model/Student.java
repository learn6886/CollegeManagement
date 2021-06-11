package com.main.java.week4.model;

/**
 * This is Student POJO class.Defines Student fields and getter-setter methods,
 * constructors.
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 */
public class Student {
	private int rollNo;
	private String studName;
	private String studContact;
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getstudName() {
		return studName;
	}

	public void setstudName(String studName) {
		this.studName = studName;
	}

	public String getStudContact() {
		return studContact;
	}

	public void setStudContact(String studContact) {
		this.studContact = studContact;
	}

	public Student() {
	}// Default constructor

	public Student(String studName, String studContact, String address) {
		super();
		this.studName = studName;
		this.studContact = studContact;
		this.address = address;
	}

}
