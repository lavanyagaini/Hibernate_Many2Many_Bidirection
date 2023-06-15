package e1_manytomany_bidirection.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import e1_manytomany_hibernate1.dao.CousreCrud;
import e1_manytomany_hibernate1.dao.StudentCrud;
import e1_manytomany_hibernate1.dto.Course;
import e1_manytomany_hibernate1.dto.Students;

public class CourseStudentMain {

	public static void main(String[] args) {

		CousreCrud crud = new CousreCrud();
		StudentCrud crud2 = new StudentCrud();
//
		Students s1 = new Students("Radha", "c@gmail.com", 4567890, "BTECh");
		Students s2 = new Students("Geetha", "u@gmail.com", 3546789, "BTECh");
		Students s3 = new Students("madhu", "j@gmail.com", 567890, "BTEch");

		Course c1 = new Course("HTMl", 10, 300);
		Course c2 = new Course("JAVA", 60, 1800);
		Course c3 = new Course("SQL", 30, 800);

		List<Students> l1 = new ArrayList<Students>();
		l1.add(s1);
		l1.add(s3);

		c1.setStudents(l1);

		List<Students> l2 = new ArrayList<Students>();
		l2.add(s1);
		l2.add(s3);
		l2.add(s2);

		c2.setStudents(l2);

		List<Students> l3 = new ArrayList<Students>();
		l3.add(s2);
		l3.add(s3);

		c3.setStudents(l3);
		
		
		List<Course>list1=new ArrayList<Course>();
		list1.add(c1);
		list1.add(c2);
		
		s1.setCourses(list1);

		List<Course>list2=new ArrayList<Course>();
		
		list2.add(c2);
		list2.add(c3);
		s2.setCourses(list2);

		List<Course>list3=new ArrayList<Course>();
		list3.add(c3);
		list3.add(c2);
		list3.add(c1);
		s3.setCourses(list3);

		EntityManager manager = crud.getmanager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(c1);//html ====radha madhu
		manager.persist(c2);//java ====radha geetha madhu
		manager.persist(c3);//sql ======geetha madhu

		transaction.commit();

	}

	//	crud2.saveStudent(s1);
		
		//Students s4 = new Students("Geetha", "r@gmail.com", 567890, "BTEch");
    
//		List<Integer>list=new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//    	crud2.saveStudent(s4, list);
//		

//		crud.saveCourse(c3);
	}

