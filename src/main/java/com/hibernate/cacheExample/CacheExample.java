package com.hibernate.cacheExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.HibernateWithMaven.Student;

public class CacheExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession(); //session caching started here
		
		Student student = session.get(Student.class, 1);
		System.out.println(student);
		
		System.out.println("Working on Somthing");
		
		Student student2 = session.get(Student.class, 1);
		
		System.out.println(student2);
		
		System.out.println(session.contains(student2));
		
		session.close(); //session caching ended here
		
		System.out.println(factory.openSession().contains(student2));
		
		factory.close();
		
	}

}
