package com.learnhibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnhibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			//Student myStudent = (Student) session.get(Student.class, studentId);
			//System.out.println("Deleting student ");
			//session.delete(myStudent);
			
			session.createQuery("delete from Student where stud_id=2").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}
	}

}
