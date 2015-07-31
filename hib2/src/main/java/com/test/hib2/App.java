package com.test.hib2;
 
import org.hibernate.Session;
 
public class App 
{
    public static void main( String[] args )
    {
        //Session session = HibernateUtil3.getSessionFactory().getCurrentSession();
    	Session session = HibernateUtil4.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Emp e1 = new Emp();
        e1.setEmpName("Sandeep Awasthi");
        session.save(e1);
        session.getTransaction().commit();
    }
}