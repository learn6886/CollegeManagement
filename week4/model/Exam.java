package com.main.java.week4.model;

/**
 * This is Exam POJO class.Defines Student fields and getter-setter methods,
 * constructors.
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 */

public class Exam {
	private int examId;
	private String course;
	private String studName;
	private int marks;

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Exam() {
	}

	public Exam(int examId, String course, String studName, int marks) {
		super();
		this.examId = examId;
		this.course = course;
		this.studName = studName;
		this.marks = marks;
	}

}
