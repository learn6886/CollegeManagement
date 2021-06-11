package com.main.java.week4.model;

/**
 * This is Course POJO class.Defines Student fields and getter-setter methods,
 * constructors.
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 */
public class Course {
	private int courseId;
	private String courseName;
	private String qualification;
	private String experience;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Course() {
	}

	public Course(int courseId, String courseName, String qualification, String experience) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.qualification = qualification;
		this.experience = experience;
	}

}
