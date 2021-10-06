package com.hibernate.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo2 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
//		Emp e1 = new Emp();
//		e1.setEmp_id(101);
//		e1.setEmpName("Aijaz A");
//		
//		Emp e2 = new Emp();
//		e2.setEmp_id(102);
//		e2.setEmpName("Ahmed A");
//		
//		List<Emp> listEmp = new ArrayList<Emp>();
//		listEmp.add(e1);
//		listEmp.add(e2);
//		
//		
//		Project p1 = new Project();
//		p1.setProject_id(201);
//		p1.setProjectName("HM");
//		
//		Project p2 = new Project();
//		p2.setProject_id(202);
//		p2.setProjectName("GYM");
//		
//		
//		List<Project> listProject = new ArrayList<Project>();
//		listProject.add(p1);
//		listProject.add(p2);
//		
//		
//		e1.setProject(listProject);
//		//p1.setEmp(listEmp);
//		
		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		session.save(e1);
//		session.save(e2);
//		session.save(p1);
//		session.save(p2);
//		
//		tx.commit();
		
		
		Emp e = session.get(Emp.class, 101);
		System.out.println(e.getEmpName());
		System.out.println(e.getProject());
		
//		for(Project p : e.getProject())
//		{
//			System.out.println(p.getProjectName());
//		}
		
		
		session.close();
		factory.close();
		
	}

}
