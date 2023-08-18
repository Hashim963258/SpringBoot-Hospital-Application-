package projectclassnew_DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Projectclassnew_DTO.MedicalRecords;

public class MedicalRecordsDao 
{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();
	
	
	public void addMedicalRecords(MedicalRecords mr)
	{
		transaction.begin();
		manager.persist(mr);
		transaction.commit();
	}
	
	
	public MedicalRecords getMedicalRecordsById(int id)
	{
		return manager.find(MedicalRecords.class, id);
	}
	
	public List<MedicalRecords> getAllMedicalRecords() 
	{
			Query q = manager.createQuery("select m from MedicalRecords m");
			
			return q.getResultList();
	}
	
	public void deleteById(int id)
	{
		MedicalRecords mr = manager.find(MedicalRecords.class, id);
		
		if(mr != null)
		{
			transaction.begin();
			manager.remove(mr);
			transaction.commit();
		}
	}
	
	public void updateMedicalRecords(MedicalRecords mr)
	{
		transaction.begin();
		manager.merge(mr);
		transaction.commit();
	}
	
	
	
	
	
}
