package com.hibernate.HibernateWithMaven;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


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

    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started" );
        
        //Getting SessionFactor Object
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        
        
        
        //Creating Student
        Student st = new Student();
        st.setId(1);
        st.setName("Aijaz");
        st.setCity("Mumbai");
        System.out.println(st);

        //Creating Address for Student
        Address address = new Address();
        address.setStreet("Bail Bazar");
        address.setCity("Mumbai");
        address.setPostal("`1526");
        address.setAddedDate(new Date());
        //taking Image File
        FileInputStream fis = new FileInputStream("image/Commonly-Used-Annotation-in-Hibernate.png");
        byte[] image = new byte[fis.available()];
        fis.read(image);
        address.setImage(image);
        
        
        
        
        //Transaction by Hibernate
        Session session = factory.openSession();	
        Transaction tx = session.beginTransaction();
        //session.save(st);
        session.save(address);
        tx.commit();
        session.close();
        factory.close();
    }
}
