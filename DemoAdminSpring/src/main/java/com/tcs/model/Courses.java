package com.tcs.model;

public class Courses {
	public Courses() {}
   public Courses(int courseId) {
		super();
		this.courseId = courseId;
	}
private int courseId;
  
   
   public int getCourseId() {
	return courseId;
}
public void setCourseId(int courseId) {
	this.courseId = courseId;
}

}
   
  