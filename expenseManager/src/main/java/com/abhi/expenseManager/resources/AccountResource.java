package com.abhi.expenseManager.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.abhi.expenseManager.objectModels.Account;
import com.abhi.expenseManager.services.AccountService;
import com.abhi.expenseManager.utils.Response;

@Path("/")
public class AccountResource {
	private AccountService accountService = AccountService.getInstance();
	
	@GET
	@Path("{accountId}")
	public Response getAccount(@PathParam("accountId")long accountId,@PathParam("userid") String userId){
		Response response = new Response();
//		response.setResponse(accountService.getAccountById(accountId,userId));
		
		return response;
	}
	
	@POST
	public Account createAccount(Account account,@PathParam("userid") String userId) {
		return accountService.createAccount(account,userId);
	}
	
	@GET
	public List<Account> getAccounts(@PathParam("userid") String userId){
		return accountService.getAcccounts(userId);
	}
	
	public Account updateAccount(Account account){
		return account;
	}
}
