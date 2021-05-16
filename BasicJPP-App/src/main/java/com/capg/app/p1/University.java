package com.capg.app.p1;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UniversityOneToMany")
public class University {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String universityName;
	private String loc;
	
	
	@ManyToOne
	@JoinColumn(name="RollNumber")
	private Student student;


	public University() {
		super();
		// TODO Auto-generated constructor stub
	}


	public University(String universityName, String loc) {
		super();
		
		this.universityName = universityName;
		this.loc = loc;
	}


	public int getId() {
		return id;
	}


	public void setId(int Id) {
		this.id = Id;
	}


	public String getUniversityName() {
		return universityName;
	}


	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}


	public String getLocation() {
		return loc;
	}


	public void setLocation(String location) {
		this.loc = location;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "University [uId=" + id + ", universityName=" + universityName + ", location=" + loc + "]";
	}
}