package com.abhi.expenseManager.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.abhi.expenseManager.objectModels.Account;
import com.abhi.expenseManager.services.AccountService;

@Path("/")
public class AccountResource {
	private AccountService accountService = AccountService.getInstance();
	
	@GET
	@Path("{accountId}")
	public Account getAccount(@PathParam("accountId")long accountId,@PathParam("userid") String userId){
		return accountService.getAccountById(accountId,userId);
	}
	
	@POST
	public Account createAccount(Account account,@PathParam("userid") String userId) {
		return accountService.createAccount(account,userId);
	}
	
	@GET
	public List<Account> getAccounts(@PathParam("userid") String userId){
		return accountService.getAcccounts(userId);
	}
}
