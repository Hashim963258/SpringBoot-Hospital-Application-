package Projectclassnew_DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pt_id;
	private String pat_name;
	private String diagnosis;
	private long phone;
	
	@ManyToOne
	@JoinColumn
	Hospital hospital;
	
	@OneToMany(mappedBy = "patient" , cascade = CascadeType.REMOVE ) 					// cascade any operation done on the below listed object will be affected
	List<MedicalRecords> records;														// mappedby specifies control the 

	public int getPt_id() {
		return pt_id;
	}

	public void setPt_id(int pt_id) {
		this.pt_id = pt_id;
	}

	public String getPat_name() {
		return pat_name;
	}

	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<MedicalRecords> getRecords() {
		return records;
	}

	public void setRecords(List<MedicalRecords> records) {
		this.records = records;
	}
	
	
	
	
}
