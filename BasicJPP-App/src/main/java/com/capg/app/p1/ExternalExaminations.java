package com.capg.app.p1;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("ExternalExam")
public class ExternalExaminations extends Examinations{
	private int externalWeightage;
	private String externalModel;
	
	public ExternalExaminations() {
		
	}

	public ExternalExaminations(int examId, String examName, int marks,int externalWeightage, String externalModel) {
		super(examId, examName, marks);
		this.externalWeightage = externalWeightage;
		this.externalModel = externalModel;
	}

	public int getExternalWeightage() {
		return externalWeightage;
	}

	public void setExternalWeightage(int externalWeightage) {
		this.externalWeightage = externalWeightage;
	}

	public String getExternalModel() {
		return externalModel;
	}

	public void setExternalModel(String externalModel) {
		this.externalModel = externalModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((externalModel == null) ? 0 : externalModel.hashCode());
		result = prime * result + externalWeightage;
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
		ExternalExaminations other = (ExternalExaminations) obj;
		if (externalModel == null) {
			if (other.externalModel != null)
				return false;
		} else if (!externalModel.equals(other.externalModel))
			return false;
		if (externalWeightage != other.externalWeightage)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExternalExaminations [externalWeightage=" + externalWeightage + ", externalModel=" + externalModel
				+ "]";
	}
}
	