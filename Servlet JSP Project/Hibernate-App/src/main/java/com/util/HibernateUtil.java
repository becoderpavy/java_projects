package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.model.User;

public class HibernateUtil {

	public static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration c = new Configuration();

				Properties p = new Properties();
				p.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				p.put(Environment.URL, "jdbc:mysql://localhost:3306/data_jpa");
				p.put(Environment.USER, "root");
				p.put(Environment.PASS, "password");
				p.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				p.put(Environment.SHOW_SQL, "true");
				p.put(Environment.HBM2DDL_AUTO, "update");

				c.setProperties(p);
				
				c.addAnnotatedClass(User.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(c.getProperties())
						.build();

				System.out.println("java config connect");

				sessionFactory = c.buildSessionFactory(serviceRegistry);

				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return sessionFactory;
	}

}
