package com.capg.app.p1;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("InternalExam")

public class InternalExaminations extends Examinations{
	private int weightage;
	private String model;
	
	public InternalExaminations() {
		
	}
	
	
	public InternalExaminations(int examId, String examName, int marks,int weightage, String model) {
		super(examId, examName, marks);
		this.weightage = weightage;
		this.model = model;
	}


	public int getWeightage() {
		return weightage;
	}


	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + weightage;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		InternalExaminations other = (InternalExaminations) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (weightage != other.weightage)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "InternalExaminations [weightage=" + weightage + ", model=" + model + "]";
	}
}
