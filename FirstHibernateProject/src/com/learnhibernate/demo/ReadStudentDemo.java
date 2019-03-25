package com.learnhibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnhibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create session factory
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Student.class).
								buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try{
			//use the session object to save java object to the database
			//create student object
			System.out.println("creating a new student object");
			Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");;
			//start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			//commit the transaction
			session.getTransaction().commit();
			
			//new code
			
			//find out the student's id : primary key
			System.out.println("saved student. generated id" + tempStudent.getStudId());
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			//retrieve the student based on the primary key
			Student myStudent = (Student) session.get(Student.class, tempStudent.getStudId());
			System.out.println("get complete: " + myStudent);
			session.getTransaction().commit();
			
			//commit the transaction
			
			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}
	}

}
