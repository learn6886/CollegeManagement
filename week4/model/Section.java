package com.main.java.week4.model;
/**
 * This is Section POJO class.Defines Student fields and getter-setter
 * methods, constructors.
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 */
public class Section {
	private int sectionId;
	private String sectionName;
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public Section() {}
	public Section(int sectionId, String sectionName) {
		super();
		this.sectionId = sectionId;
		this.sectionName = sectionName;
	}
	
}
