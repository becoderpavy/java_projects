package com.servlet;

import org.hibernate.Hibernate;

import com.provider.HibernateUtil;

public class Register {
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
	}
}
