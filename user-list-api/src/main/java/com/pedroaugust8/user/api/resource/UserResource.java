package com.pedroaugust8.user.api.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pedroaugust8.user.api.service.UserService;
import com.pedroaugust8.user.core.User;

@Path("/user")
public class UserResource {
	private UserService userService;
	
	@Inject
	public UserResource(UserService userService){
		this.userService = userService;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(User user){
		System.out.println(user);
		//ReflectionToStringBuilder.toString(user)
		this.userService.addUser(user);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> list(){
		System.out.println("OLAAAAR");
		return this.userService.list();
	}
}
