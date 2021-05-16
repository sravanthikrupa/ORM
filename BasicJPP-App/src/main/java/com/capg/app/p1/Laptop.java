package com.capg.app.p1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	private int id;
	private String brandName;
	
	
	@OneToOne(mappedBy = "laptop")
	private Student student;
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Laptop(int id, String brandName) {
		super();
		this.id = id;
		this.brandName = brandName;
	}

	

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brandName=" + brandName + "]";
	}
}
