package com.capg.app.p2;


import java.util.ArrayList;
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
@Table(name="Course1")
public class Course1 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String courseName;
	private int duration;
	private String trainerName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="StudentApp_courses",
			joinColumns=@JoinColumn(name="Course_ID"),
			inverseJoinColumns=@JoinColumn(name="StudentApp"))
	private List<Student> studentApps;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public List<Student> getStudentApps() {
		return studentApps;
	}

	public void setStudentApps(List<Student> studentApps) {
		this.studentApps = studentApps;
	}
	
}