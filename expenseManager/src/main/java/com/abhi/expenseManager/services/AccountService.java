package com.abhi.expenseManager.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.abhi.expenseManager.objectModels.Account;
import com.abhi.expenseManager.objectModels.User;

public class AccountService {
	private static AccountService accountService = null;
	
	private AccountService(){
	}
	
	public static AccountService getInstance(){
		if(accountService == null)
			accountService = new AccountService();
		
		return accountService;
	}
	
	public Account getAccountById(long accountId,String userId){
		Session session = PersistantFactory.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from accounts where user_id=? and account_id=?");
		query.setString(0, userId);
		query.setLong(1, accountId);
		List<Account> accounts = query.list();
		session.getTransaction().commit();
		session.close();
		
		return accounts.size() > 0 ?(Account) accounts.get(0):null;
	}
	
	public Account createAccount(Account account,String userId){
		Session session = PersistantFactory.getSession();
		session.beginTransaction();
		User user = new User();
		user.setEmailId(userId);
		account.setUser(user);
		session.saveOrUpdate(account);
		session.getTransaction().commit();
		session.close();
		
		return account;
		
	}

	public List<Account> getAcccounts(String userId) {
		Session session = PersistantFactory.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from accounts where user_id=?");
		query.setParameter(0, userId);
		List<Account> accounts = query.list();
		session.getTransaction().commit();
		session.close();
		
		return accounts;
	}
}
