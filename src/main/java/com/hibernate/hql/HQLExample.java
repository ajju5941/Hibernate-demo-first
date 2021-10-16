package com.hibernate.hql;

import java.util.List;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.HibernateWithMaven.Student;

public class HQLExample {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		String query = "from Student where course='Java'";
		Query q = s.createQuery(query);

		List<Student> list = q.list();
		
		for(Student student:list)
		{
			System.out.println(student.getName()+" : "+student.getCerti().getCourse());
		}
	}
	
}
