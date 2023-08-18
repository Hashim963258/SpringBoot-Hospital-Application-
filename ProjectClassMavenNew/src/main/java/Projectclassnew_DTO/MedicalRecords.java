package Projectclassnew_DTO;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MedicalRecords 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int md_id;
	private String problem;
	private String date_of_checkup;
	
	@ManyToOne
	@JoinColumn
	Patient patient;

	public int getMd_id() {
		return md_id;
	}

	public void setMd_id(int md_id) {
		this.md_id = md_id;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDate_of_checkup() {
		return date_of_checkup;
	}

	public void setDate_of_checkup(String date_of_checkup) {
		this.date_of_checkup = date_of_checkup;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
	
	
}
