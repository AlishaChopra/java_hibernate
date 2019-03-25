package com.learnhibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnhibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent = new Student("Paul","Wall","paul@luv2code.com");
			//start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("saving the student...");
			session.save(tempStudent);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}
	}

}
