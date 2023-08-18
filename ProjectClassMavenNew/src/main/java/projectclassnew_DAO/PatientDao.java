package projectclassnew_DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Projectclassnew_DTO.Patient;

public class PatientDao 
{

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();
	
	
	public void addPatient(Patient pat)
	{
		transaction.begin();
		manager.persist(pat);
		transaction.commit();
	}
	
	public Patient getPatientById(int id)
	{
		return  manager.find(Patient.class, id);
		
	}
	
	public List<Patient> getAllPatient()
	{
		Query q = manager.createQuery("select p from Patient p");
		return q.getResultList();
		
	}
	
	public void deleteById(int id)
	{
		Patient p = manager.find(Patient.class, id);
		
		if(p != null)
		{
			transaction.begin();
			manager.remove(p);
			transaction.commit();
		}
		else
		{
			System.out.println("Patient with ID : "+id+" is not present");
		}
	}
	
	
	public void updatePatient(Patient patient)
	{
		transaction.begin();
		manager.merge(patient);
		transaction.commit();
	}
	
	
	
	
}
