package com.capg.app.p2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="StudentApp")
public class Student {
	@Id
	private int SId;
	private String name;
	private int age;
	private String email;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="StudentApp_courses",
			joinColumns=@JoinColumn(name="StudentApp"),
			inverseJoinColumns=@JoinColumn(name="Course_ID"))
	private List<Course1> courseList;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSId() {
		return SId;
	}

	public void setSId(int sId) {
		SId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course1> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course1> courseList) {
		this.courseList = courseList;
	}
}
