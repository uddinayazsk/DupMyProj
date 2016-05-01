package com.dao;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.action.User;

public class LoginDaoImpl implements LoginDao
{
    
    private Session getSession() {
	Session s = null;
	try {
		File f = new File("D:\\backupE\\j2e6e\\correct code\\navith\\DupMyProj\\src\\com\\action\\hibernate.cfg.xml");
		SessionFactory sessionFactory = new Configuration().configure(f).buildSessionFactory(); 
		s = sessionFactory.openSession();
		
	} catch (HibernateException e) {
		System.out.println("Exception in getSession()--> "+e.getMessage());
	}
	return s;
}
    

    @Override
    public boolean authenticateUser(String userName, String password)
    {
    	
	System.out.println("---Login Dao Impl---");
	String name = userName;
	String pwd =password;
	boolean flag = false;
	try {

		Session session = getSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from User1 usr");// usr is the reference for
													// table(pojo)
		List li = q.list();// taking the data from hibernate(q) to java(li)
		Iterator it = li.iterator();
		System.out.println("Query Loop starts");
		int cnt=0;
		System.out.println("Query Loop starts for "+cnt);
		while (it.hasNext()) {
			System.out.println("enter for "+ ++cnt+" times");
			User u = (User) it.next();// name==user name &
										// getusername==database name

			if (name.equals(u.getName()) & pwd.equals(u.getPwd()))
				flag = true;
			System.out.println("within loop ,Flag="+flag);
		}
	} catch (HibernateException e) {
		System.out.println(e.getMessage());
	}
	System.out.println("Flag=  "+flag);
	return flag;
    }

}
