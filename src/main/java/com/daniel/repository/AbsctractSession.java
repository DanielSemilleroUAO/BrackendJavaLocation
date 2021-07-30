package com.daniel.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbsctractSession {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
}
