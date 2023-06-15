package e1_manytomany_hibernate1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import e1_manytomany_hibernate1.dto.Course;
import e1_manytomany_hibernate1.dto.Students;

public class StudentCrud {
	public EntityManager getmanager() {
		return Persistence.createEntityManagerFactory("Lavanya").createEntityManager();
	}


	public void saveStudent(Students students, List<Integer> list) {
		EntityManager manager = getmanager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(students);
		for (Integer id : list) {
			Course course = manager.find(Course.class, id);
			if (course != null) {

				List<Students> studentslist = new ArrayList<Students>();
				studentslist.add(students);
				studentslist.addAll(course.getStudents());

				course.setStudents(studentslist);
				manager.merge(course);
			}
		}
		transaction.commit();
	}

}
