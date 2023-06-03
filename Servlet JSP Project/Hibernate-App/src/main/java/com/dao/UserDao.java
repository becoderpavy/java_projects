package com.dao;

import java.io.Serializable;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.User;
import com.util.HibernateUtil;

public class UserDao {

	public boolean saveUser(User u) {
		boolean f = false;
		Transaction t = null;
		try {
			Session s = HibernateUtil.getSessionFactory().openSession();
			t = s.beginTransaction();

			s.save(u);
			t.commit();
			f = true;
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
				f = false;
			}
			e.printStackTrace();
		}
		return f;
	}
	
	public User getUser(int id)
	{
		User u = null;
		Transaction t = null;
		try {
			Session s = HibernateUtil.getSessionFactory().openSession();
			t = s.beginTransaction();
			
			u=s.get(User.class, id);
			t.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return u;
		
	}
	
	public boolean checkUser(String email,String psw)
	{
		Transaction t = null;
		User u=null;
		boolean f=false;
		try {
			Session s=HibernateUtil.getSessionFactory().openSession();
			t=s.beginTransaction();
			
		 User us =(User) s.createQuery("from User u where u.email=:em").setParameter("em", email)
				 .uniqueResult();
		  
		 // q.setParameter("ps", psw);
		  
		  
		  if(us!=null)
		  {
			  System.out.println(us);
		  }
		  else {
			  System.out.println("error");
		  }
		  
		
		  
		  t.commit();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
	
	
	

}
