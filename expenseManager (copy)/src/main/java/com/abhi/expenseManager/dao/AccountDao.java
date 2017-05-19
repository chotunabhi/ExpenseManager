package com.abhi.expenseManager.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.abhi.expenseManager.objectModels.Account;
import com.abhi.expenseManager.objectModels.User;
import com.abhi.expenseManager.utils.HibernateUtil;

public class AccountDao {
	private static AccountDao accountDao;
	Session session = null;
	
	private AccountDao(){
	}
	
	public static AccountDao getInstance(){
		if(accountDao == null)
			accountDao = new AccountDao();
		
		return accountDao;
	}

	public Account getAccountById(long accountId, String userId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from accounts where user_id=? and account_id=?");
		query.setString(0, userId);
		query.setLong(1, accountId);
		List<Account> accounts = query.list();
		session.getTransaction().commit();
		session.close();
		
		return accounts.size() > 0 ?(Account) accounts.get(0):null;
	}

	public Account createAccount(Account account, String userId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User user = new User();
		user.setEmailId(userId);
		account.setUser(user);
		session.saveOrUpdate(account);
		session.getTransaction().commit();
		session.close();
		
		return account;
	}

	public List<Account> getAccounts(String userId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from accounts where user_id=?");
		query.setParameter(0, userId);
		List<Account> accounts = query.list();
		session.getTransaction().commit();
		session.close();
		
		return accounts;
	}
}
