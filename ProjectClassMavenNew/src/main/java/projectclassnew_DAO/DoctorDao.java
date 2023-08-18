package projectclassnew_DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Projectclassnew_DTO.Doctor;



public class DoctorDao 
{
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();

	
	public void addDoctor(Doctor doc)
	{
		transaction.begin();
		manager.persist(doc);
		transaction.commit();
	}
	
	
	public Doctor getDoctorById(int id)
	{
		return manager.find(Doctor.class, id);
	}
	
	public List<Doctor> getAllDoctor()
	{
		Query q = manager.createQuery("select d from Doctor d");
		return q.getResultList();
		
	}
	
	public void deleteById(int id)
	{
		Doctor d = getDoctorById(id);
		
		if(d != null)
		{
			transaction.begin();
			manager.remove(d);
			transaction.commit();
		}
		else
		{
			System.out.println("Hospital with ID : "+id+" is not present");
		}
	}
	
	
	public void updateDoctor(Doctor doctor)
	{
		transaction.begin();
		manager.merge(doctor);
		transaction.commit();
	}
	
}
