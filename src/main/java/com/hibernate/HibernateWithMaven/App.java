package com.hibernate.HibernateWithMaven;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        System.out.println( "Project Started" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        //Creating Student
        Student st = new Student();
        st.setId(1);
        st.setName("Aijaz");
        st.setCity("Mumbai");
        System.out.println(st);
        
        Session session = factory.openSession();	
        
        Transaction tx = session.beginTransaction();
        session.save(st);
        tx.commit();
        session.close();
        
    }
}
