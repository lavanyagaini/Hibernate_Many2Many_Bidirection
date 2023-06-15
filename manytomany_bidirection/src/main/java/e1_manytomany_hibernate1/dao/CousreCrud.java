package e1_manytomany_hibernate1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import e1_manytomany_hibernate1.dto.Course;
import e1_manytomany_hibernate1.dto.Students;

public class CousreCrud {
	
	public EntityManager getmanager() {
		return Persistence.createEntityManagerFactory("Lavanya").createEntityManager();
	}
	
	public void saveCourse(Course course) {
		EntityManager manager=getmanager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(course);
		transaction.commit();
		
	
		
	}
	
	

	
	
	
	

}
