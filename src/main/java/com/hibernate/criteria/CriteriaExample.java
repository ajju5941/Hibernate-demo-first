package com.hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.HibernateWithMaven.Student;

public class CriteriaExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Criteria c = session.createCriteria(Student.class);
//		c.add(Restrictions.eq("certi.course","Java"));
//		c.add(Restrictions.like("certi.course","c%"));
		c.add(Restrictions.gt("id",50));
		
		
		List<Student> list = c.list();
		
		for(Student s : list)
		{
			System.out.println(s);
		}
		
		
		session.close();
		factory.close();
		

	}

}
