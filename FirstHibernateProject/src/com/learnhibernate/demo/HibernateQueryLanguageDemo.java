package com.learnhibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnhibernate.demo.entity.Student;

public class HibernateQueryLanguageDemo {

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
			
			//start a transaction
			session.beginTransaction();
			//query the student
			List<Student> theStudents = session.createQuery("from Student").list();
			//display the student
			
			displayStudentList(theStudents);
			
			//Query lastname from student
			theStudents = session.createQuery("from Student s where s.lName='public'").list();
			displayStudentList(theStudents);
			
			//Query students with last name "public" or first name "Bonita"
			theStudents = session.createQuery("from Student s where" 
			+ " s.lName='public' OR s.fName='bonita'").list();
			displayStudentList(theStudents);
			
			//Query students where email like 'luv2code'
			theStudents = session.createQuery("from Student s where" 
			+ " s.email like '%luv2code.com'").list();
			displayStudentList(theStudents);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}
	}

	private static void displayStudentList(List<Student> theStudents) {
		for(Student temp : theStudents)
		{
			System.out.println(temp.getStudId()+ " " + temp.getfName() + " " + temp.getlName()+ " " + temp.getEmail());
		}
	}

}
