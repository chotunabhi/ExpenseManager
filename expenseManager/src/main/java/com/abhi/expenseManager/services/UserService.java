package com.abhi.expenseManager.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.abhi.expenseManager.dao.UserDao;
import com.abhi.expenseManager.objectModels.User;
import com.abhi.expenseManager.utils.HibernateUtil;
import com.abhi.expenseManager.utils.Response;

public class UserService {
	private UserDao userDao = UserDao.getInstance();
	private static UserService userService = null;
	
	
	private UserService(){
	}

	public static UserService getInstance(){
		if(userService == null)
			userService = new UserService();

		return userService;
	}

	public User getUserById(String userId) {
		return userDao.getUserById(userId);
	}

	public boolean createUser(User user) {
		return userDao.createUser(user);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public List<User> getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}

	public User deleteAccount(String userId) {
		return userDao.deleteAccount(userId);
	}
	
	/*public User loginUser(User user){
		
	}*/
}
