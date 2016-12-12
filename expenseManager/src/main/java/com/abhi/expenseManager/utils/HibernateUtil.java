package com.abhi.expenseManager.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private SessionFactory sessionFactory = null;
	private static HibernateUtil factory = null;
	
	private HibernateUtil(){
		
	}
	
	public static Session getSession(){
		if(factory == null)
			factory = new HibernateUtil();
		
		if(factory.sessionFactory == null){
			Configuration configure = new Configuration().configure();
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
			registryBuilder.applySettings(configure.getProperties());
			
			StandardServiceRegistry serviceRegistry = registryBuilder.build();
			
			factory.sessionFactory = configure.buildSessionFactory(serviceRegistry);
		}
		
		return factory.sessionFactory.openSession();
		
	}
}
