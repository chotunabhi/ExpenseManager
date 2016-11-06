package com.abhi.expenseManager.services;

import java.util.List;

import org.hibernate.Session;

import com.abhi.expenseManager.objectModels.User;

public class UserService {
	private static UserService userService = null;

	private UserService(){
	}

	public static UserService getInstance(){
		if(userService == null)
			userService = new UserService();

		return userService;
	}

	public User getUserById(String userId) {
		Session session = PersistantFactory.getSession();
		User user = session.get(User.class, userId);
		session.close();
		
		return user;
	}

	public User createUser(User user) {
		Session session = PersistantFactory.getSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
		
		return user;
	}
}
