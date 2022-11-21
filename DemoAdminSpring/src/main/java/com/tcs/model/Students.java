package com.tcs.model;

import java.util.Collection;

public class Students {

	public Students() {
		// TODO Auto-generated constructor stub
	}
	private int studId;
	private String studName;
	private int courseId;
	private int status;
	
	public Students(int studId, String studName, int courseId,int status) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.courseId = courseId;
		this.status=status;
	}
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	

}
