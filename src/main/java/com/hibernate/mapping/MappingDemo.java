package com.hibernate.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	private static Session session;

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Questions q1 = new Questions();
		q1.setQuestion_id(101);
		q1.setQuestion("What is Java?");
		
		Answer ans1 = new Answer();
		ans1.setAnswer_id(201);
		ans1.setAnswer("Java is a Programming Language.");
		ans1.setQuestion(q1);
		
		Answer ans2 = new Answer();
		ans2.setAnswer_id(202);
		ans2.setAnswer("Java is also a Platform.");
		ans2.setQuestion(q1);
		
		Answer ans3 = new Answer();
		ans3.setAnswer_id(203);
		ans3.setAnswer("Java has many framworks to create software.");
		ans3.setQuestion(q1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);
		
		q1.setAnswer(list);
		
		
		session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(q1);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		
		tx.commit();
		
		Questions q = session.get(Questions.class, 101);
		
		System.out.println(q.getQuestion());
		
		for(Answer ans : q.getAnswer()) {
			System.out.println(ans.getAnswer());
			
		}
		
		
		session.close();
		factory.close();
		

	}

}
