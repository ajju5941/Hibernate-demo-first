package com.hibernate.HibernateWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchStudentDetails {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		//Fetching Student of ID : 1 using Load() method
		//If we pass ID which is not in table it will throw ObjectNotFoundException  
		Student student = (Student)session.load(Student.class, 1);
		System.out.println(student);
		
		
		//Fetching Student Address of ID : 1 using get() method
		//If we pass ID which is not in table it will return "null"
		//and if we try to get something through returned "null" object it will throw "NullPointerException" 
		Address address = (Address)session.get(Address.class, 1);
		System.out.println("Street : "+address.getStreet()+", City : "+address.getCity()+", Date : "+address.getAddedDate());
		
		//Here ID 2 doesn't exist it will throw null pointer exception
//		Address address2 = (Address)session.get(Address.class, 2);
//		System.out.println("Street : "+address2.getStreet()+", City : "+address2.getCity()+", Date : "+address2.getAddedDate());
		
		session.close();
		factory.close();
		
	}

}
