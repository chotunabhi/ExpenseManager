package com.abhi.expenseManager.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.abhi.expenseManager.objectModels.User;
import com.abhi.expenseManager.services.UserService;

@Path("users")
@Produces(value={MediaType.APPLICATION_JSON})
public class UserResource {
	UserService userService = UserService.getInstance();

	//gets user based on the userid
	@GET
	@Path("{userId}")
	public User getUser(@PathParam("userId")String userId){
		return userService.getUserById(userId);
	}

	//get all users
	@GET
	public List<User> getUsers(){
		return userService.getAllUsers();
	}

	//create a user
	@POST
	@Consumes(value={MediaType.APPLICATION_JSON})
	public Boolean createUser(User user){
		return userService.createUser(user);
	}

	@DELETE
	@Path("{userId}")
	public User deleteAccount(@PathParam("userId")String userId){
		return userService.deleteAccount(userId);
	}

	public User updateUser(User user){
		return user;
	}

	//get account related data	
	@Path("{userid}/accounts")
	public AccountResource getAccount() {
		return new AccountResource();
	}

}
