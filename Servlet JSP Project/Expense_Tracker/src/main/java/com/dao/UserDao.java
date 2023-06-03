package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.User;

public class UserDao {

	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;

	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public boolean register(User user) {
		boolean f = false;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			session.save(user);
			tx.commit();
			f = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				f = false;
				e.printStackTrace();
			}
		}
		return f;
	}
}
