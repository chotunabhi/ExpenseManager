package com.abhi.expenseManager.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.abhi.expenseManager.objectModels.User;
import com.abhi.expenseManager.utils.HibernateUtil;

public class UserDao {
	private static UserDao userDao;
	Session session = null;
	private ProjectionList projections = Projections.projectionList().add(Projections.property("emailId"), "emailId")
			.add(Projections.property("phoneNumber"), "phoneNumber").add(Projections.property("age"), "age")
			.add(Projections.property("gender"), "gender").add(Projections.property("active"), "active")
			.add(Projections.property("primaryAccount"), "primaryAccount");

	public static UserDao getInstance() {
		if (userDao == null)
			userDao = new UserDao();

		return userDao;
	}

	public User getUserById(String userId) {
		session = HibernateUtil.getSession();
		session.beginTransaction();

		List<User> list = session.createCriteria(User.class).setProjection(projections)
				.add(Restrictions.eq("emailId", userId)).setResultTransformer(Transformers.aliasToBean(User.class))
				.list();

		User user = list.isEmpty() ? null : list.get(0);

		session.getTransaction().commit();
		session.close();

		return user;
	}

	public boolean createUser(User user) {
		session = HibernateUtil.getSession();
		session.beginTransaction();

		if (user.getPrimaryAccount() != null)
			user.getPrimaryAccount().setUser(user);
		user.setActive(true);
		String save = (String) session.save(user);
		session.getTransaction().commit();
		session.close();

		user.setPassword(null);
		return save != null ? true : false;

	}

	public List<User> getAllUsers() {

		session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from user_details");

		List<User> users = (List<User>) query.list();

		session.getTransaction().commit();
		session.close();

		return users;

	}

	public List<User> getUserByName(String userName) {
		session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from user_details where userName= :userName");
		query.setParameter("userName", userName);
		session.getTransaction().commit();
		List<User> users = query.list();
		session.close();

		return users;
	}

	public User deleteAccount(String userId) {
		session = HibernateUtil.getSession();
		session.beginTransaction();

		Query query = session.createQuery("select u.emailId,u.active from user_details u where u.emailId=:emailId");
		query.setString("emailId", userId);
		List<User> list = query.list();
		System.out.println(list.getClass());
		for (Object user : list) {
			System.out.println(user.getClass());
		}
		// User user = list.
		// user.setActive(false);
		// session.update(user);
		session.getTransaction().commit();

		return new User();
	}

	public User loginUser(User user) {
		session = HibernateUtil.getSession();
		session.beginTransaction();

		Query query = session.createQuery("from user_details u where u.emailId=:emailId and u.password=:password");
		query.setString("emailId", user.getEmailId());
		query.setString("password", user.getPassword());

		List<User> list = query.list();

		session.getTransaction().commit();

		return list.size() > 0 ? list.get(0) : null;
	}
}
