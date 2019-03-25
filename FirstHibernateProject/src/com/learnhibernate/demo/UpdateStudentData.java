package com.learnhibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnhibernate.demo.entity.Student;

public class UpdateStudentData {

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
			int studentId = 1;
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\ngetting student with id: " + studentId );
			Student myStudent = (Student) session.get(Student.class, studentId);
			System.out.println("Updating student ");
			myStudent.setfName("Scooby");
			session.getTransaction().commit();
			System.out.println("Done!");
			
			//New Code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email = 'foo@gmail.com'")
								.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student temp : theStudents)
		{
			System.out.println(temp);
		}
	}

}
