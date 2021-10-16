package com.hibernate.hql;


import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.HibernateWithMaven.Student;

public class HQLExample {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
//		String query = "from Student where course=:x";
//		Query q = s.createQuery(query);
//		
//		q.setParameter("x", "Python");
//
//		List<Student> list = q.list();
//		
//		for(Student student:list)
//		{
//			System.out.println(student.getName()+" : "+student.getCerti().getCourse());
//		}
		
		Transaction tx = s.beginTransaction();
		//Delete Transaction
//		String query2 = "delete from Student where course=:c";
//		Query q2 = s.createQuery(query2);
//		q2.setParameter("c", "abc");
//		
//		int i = q2.executeUpdate();
//		System.out.println(i+" Rows deleted");
		
		//Update Transaction
//		String query2 = "update from Student set duration=:d where course=:c";
//		Query q2 = s.createQuery(query2);
//		q2.setParameter("d", "1.5 Months");
//		q2.setParameter("c", "Hibernate");
//		
//		int i = q2.executeUpdate();
//		System.out.println(i+" Rows updated");
	
//		Query q3 = s.createQuery("select q.question_id, q.question, a.answer from Questions q inner join q.answer as a ");
//		List<Object[]> list2 = q3.getResultList();
//		
//		for(Object[] arr:list2) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		
		//Pegination
		String query = "from Student";
		Query q = s.createQuery(query);
		
		q.setFirstResult(10);//Starting point
		
		q.setMaxResults(50);// here 50 indicates home rows you want

		List<Student> list = q.list();
		
		for(Student student:list)
		{
			System.out.println(student.getName()+" : "+student.getCerti().getCourse());
		}
		
		tx.commit();
		s.close();
		factory.close();
		
		
	}
	
}
