package com.capg.app.p1;

import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class Certifications {
	@Column(name = "TechnicalCertificates")
	private int technicalCertificate;
	@Column(name = "Non_Technical_Certificates")
	private int nonTechnicalCertificate;

	public Certifications() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certifications(int technicalCertificate, int nonTechnicalCertificate) {
		super();
		this.technicalCertificate = technicalCertificate;
		this.nonTechnicalCertificate = nonTechnicalCertificate;
	}

	public int getTechnicalCertificate() {
		return technicalCertificate;
	}

	public void setTechnicalCertificate(int technicalCertificate) {
		this.technicalCertificate = technicalCertificate;
	}

	public int getNonTechnicalCertificate() {
		return nonTechnicalCertificate;
	}

	public void setNonTechnicalCertificate(int nonTechnicalCertificate) {
		this.nonTechnicalCertificate = nonTechnicalCertificate;
	}

	@Override
	public String toString() {
		return "Certifications [technicalCertificate=" + technicalCertificate + ", nonTechnicalCertificate="
				+ nonTechnicalCertificate + "]";
	}
}

	