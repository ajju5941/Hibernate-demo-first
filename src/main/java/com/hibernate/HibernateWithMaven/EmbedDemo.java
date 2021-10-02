package com.hibernate.HibernateWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student = new Student();
		student.setId(1);
		student.setName("Aijaz");
		student.setCity("Mumbai");
		
		Certificate certi = new Certificate();
		certi.setCourse("Java");
		certi.setDuration("3 Months");
		student.setCerti(certi);
		
		Student student1 = new Student();
		student1.setId(2);
		student1.setName("Ahmed");
		student1.setCity("Mumbai");
		
		Certificate certi1 = new Certificate();
		certi1.setCourse("Python");
		certi1.setDuration("2.5 Months");
		student1.setCerti(certi1);		
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(student);
		session.save(student1);
		tx.commit();
		
		session.close();
		factory.close();
		
	}

}
