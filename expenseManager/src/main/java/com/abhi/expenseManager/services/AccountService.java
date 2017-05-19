package com.abhi.expenseManager.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.abhi.expenseManager.dao.AccountDao;
import com.abhi.expenseManager.objectModels.Account;
import com.abhi.expenseManager.objectModels.User;
import com.abhi.expenseManager.utils.HibernateUtil;

public class AccountService {
	private static AccountService accountService = null;
	private AccountDao accountDao = AccountDao.getInstance();
	
	private AccountService(){
	}
	
	public static AccountService getInstance(){
		if(accountService == null)
			accountService = new AccountService();
		
		return accountService;
	}
	
	public Account getAccountById(long accountId,String userId){
		return accountDao.getAccountById(accountId,userId);
	}
	
	public Account createAccount(Account account,String userId){
		return accountDao.createAccount(account,userId);
	}

	public List<Account> getAcccounts(String userId) {
		return accountDao.getAccounts(userId);
	}
}
