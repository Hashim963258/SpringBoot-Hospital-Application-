package projectclassnew_DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Projectclassnew_DTO.Hospital;

public class HospitalDao 
{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();
	
	
	public void createHospital(Hospital hosp)
	{
		transaction.begin();
		manager.persist(hosp);
		transaction.commit();
	}
	
	
	public Hospital getHospitalById(int id)
	{
		return manager.find(Hospital.class, id);
	}
	
	
	public List<Hospital> getAllHospital()
	{
		Query q = manager.createQuery("select h hospital from h");
		return q.getResultList();
	}
	
	
	public void removeHospital(int id)
	{
		Hospital h = getHospitalById(id);
		if(h != null)
		{
			transaction.begin();
			manager.remove(h);
			transaction.commit();
		}
		
	}
	
	public void updateHospital(Hospital hospital)
	{

			transaction.begin();
			manager.merge(hospital);
			transaction.commit();
		
		
	}
	
	
	
	
	
	
}
