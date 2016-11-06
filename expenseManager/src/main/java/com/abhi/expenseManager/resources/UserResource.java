package com.abhi.expenseManager.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.abhi.expenseManager.objectModels.User;
import com.abhi.expenseManager.services.UserService;

@Path("users")
@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
public class UserResource {
	UserService userService = UserService.getInstance();
	
	@GET
	@Path("{userId}")
	public User getUser(@PathParam("userId")String userId){
		return userService.getUserById(userId);
	}
	
	@POST
	@Consumes(value={MediaType.APPLICATION_JSON})
	public User createUser(User user){
		return userService.createUser(user);
	}
}
