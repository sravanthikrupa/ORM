package com.capg.app.p1;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Courses {
	@Column(name = "TechnicalCourseId")
	private int courseId;
	@Column(name = "TechnicalCourseName")
	private String courseName;
	@Column(name = "TechnicalCourseDuration")
	private int duration;

	
	
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Courses(int courseId, String courseName, int duration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
	}


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


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + "]";
	}
}
	
	
