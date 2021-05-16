package com.capg.app.p1;

import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity   
@Table(name = "BVRITHStudent")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RollNumber")
	private int Id;
	@Column(name=" StudentName")
	private String name;
	private int marks;
	private int age;
	
	
	@Embedded
	private Courses technicalCourse;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "courseId",column = @Column(name="nonTechnicalCourseId")),
		@AttributeOverride(name = "courseName",column = @Column(name="nonTechnicalCourseName")),
		@AttributeOverride(name = "duration",column = @Column(name="nonTechnicalCourseDuration"))
	})
	private Courses nonTechnicalCourse;
	
	@ElementCollection
	@CollectionTable(name="CertificateInfo",joinColumns = @JoinColumn(name="RollNumber"))
	Set<Certifications> certificate;
	
	
	//one to one============
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Laptop_Id",referencedColumnName = "id")
	private Laptop laptop;
	
	
//  one to many 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="RollNumber")
	private List<University> university;
	
	//onetomany
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="RollNumber")
	private List<Examinations> examList;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Student(int id, String name, int marks, int age, Courses technicalCourse, Courses nonTechnicalCourse,
			Set<Certifications> certificate) {
		super();
		Id = id;
		this.name = name;
		this.marks = marks;
		this.age = age;
		this.technicalCourse = technicalCourse;
		this.nonTechnicalCourse = nonTechnicalCourse;
		this.certificate = certificate;
	}


	public List<Examinations> getExamList() {
		return examList;
	}


	public void setExamList(List<Examinations> examList) {
		this.examList = examList;
	}


	public List<University> getUniversity() {
		return university;
	}


	public void setUniversity(List<University> university) {
		this.university = university;
	}


	public Laptop getLaptop() {
		return laptop;
	}


	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}


	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Courses getTechnicalCourse() {
		return technicalCourse;
	}

	public void setTechnicalCourse(Courses technicalCourse) {
		this.technicalCourse = technicalCourse;
	}

	public Courses getNonTechnicalCourse() {
		return nonTechnicalCourse;
	}

	public void setNonTechnicalCourse(Courses nonTechnicalCourse) {
		this.nonTechnicalCourse = nonTechnicalCourse;
	}

	public Set<Certifications> getCertificate() {
		return certificate;
	}

	public void setCertificate(Set<Certifications> certificate) {
		this.certificate = certificate;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", marks=" + marks + ", age=" + age + ", technicalCourse="
				+ technicalCourse + ", nonTechnicalCourse=" + nonTechnicalCourse + ", certificate=" + certificate + "]";
	}
	
}