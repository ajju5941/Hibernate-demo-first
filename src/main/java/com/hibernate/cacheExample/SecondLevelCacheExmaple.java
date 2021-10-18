package com.hibernate.cacheExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.HibernateWithMaven.Student;

public class SecondLevelCacheExmaple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Second Level Cache Started)
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession(); 
		
		Student student = session.get(Student.class, 1);
		System.out.println(student);
		
		session.close();
		
		Session session1 = factory.openSession();
		
		Student student1 = session1.get(Student.class, 1);
		System.out.println(student1);
		
		session1.close();
		
		factory.close();
		
		
	}

}
