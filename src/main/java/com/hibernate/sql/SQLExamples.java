package com.hibernate.sql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.mapping.Answer;
import com.hibernate.mapping.Questions;

public class SQLExamples {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Questions q1 = new Questions();
		q1.setQuestion_id(1234);
		q1.setQuestion("What is Hibernate?");
		
		Answer a1 = new Answer(567, "Hibernate is a framwork", q1);
		Answer a2 = new Answer(568, "Hibernate is also a ORM Tool", q1);
		Answer a3 = new Answer(569, "Hibernate do the database work for us", q1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswer(list);
		
		
		Transaction transaction = session.beginTransaction();
		
		session.save(q1);
		
		transaction.commit();
		
		session.close();
		factory.close();
		

	}

}
