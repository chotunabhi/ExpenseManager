package com.abhi.expenseManager.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersistantFactory {
	private SessionFactory sessionFactory = null;
	private static PersistantFactory factory = null;
	
	private PersistantFactory(){
		
	}
	
	public static Session getSession(){
		if(factory == null)
			factory = new PersistantFactory();
		
		if(factory.sessionFactory == null)
			factory.sessionFactory = new Configuration().configure().buildSessionFactory();
		
		return factory.sessionFactory.openSession();
		
	}
}
