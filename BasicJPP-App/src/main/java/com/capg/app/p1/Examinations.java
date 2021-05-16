package com.capg.app.p1;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.capg.app.p3.Insurance;

//import com.capg.jpa.p1.Account;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
		 name = "Policy_Type",
		 discriminatorType =DiscriminatorType.STRING
		)
public class Examinations implements Comparable<Examinations>,Serializable
{
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int examId;
	private String examName;
	private int marks;
	
	@ManyToOne
	@JoinColumn(name="RollNumber")
	private Student student;
	
	public Examinations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Examinations(int examId, String examName, int marks) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.marks = marks;
	}
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examId;
		result = prime * result + ((examName == null) ? 0 : examName.hashCode());
		result = prime * result + marks;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Examinations other = (Examinations) obj;
		if (examId != other.examId)
			return false;
		if (examName == null) {
			if (other.examName != null)
				return false;
		} else if (!examName.equals(other.examName))
			return false;
		if (marks != other.marks)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Examinations [examId=" + examId + ", examName=" + examName + ", marks=" + marks + "]";
	}
	
	
	@Override
	public int compareTo(Examinations o) {
		// TODO Auto-generated method stub
		return 0;
	}
}