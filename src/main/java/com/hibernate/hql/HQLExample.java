package com.hibernate.hql;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.hibernate.HibernateWithMaven.Student;

public class HQLExample {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		String query = "from Student where course=:x";
		Query q = s.createQuery(query);
		
		q.setParameter("x", "Python");

		List<Student> list = q.list();
		
		for(Student student:list)
		{
			System.out.println(student.getName()+" : "+student.getCerti().getCourse());
		}
		
		Transaction tx = s.beginTransaction();
		String query2 = "delete from Student where course=:c";
		Query q2 = s.createQuery(query2);
		q2.setParameter("c", "abc");
		
		int i = q2.executeUpdate();
		System.out.println(i+" Rows deleted");
		tx.commit();
		s.close();
		factory.close();
		
		
	}
	
}
