package com.pedroaugust8.user.store.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pedroaugust8.user.core.User;
import com.pedroaugust8.user.store.service.UserStoreService;

@Path("/user")
public class UserStoreResource {
	private final UserStoreService storeService;
	
	@Inject
	public UserStoreResource(UserStoreService service){
		this.storeService = service;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(User user){
		this.storeService.save(user);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> list(){
		return this.storeService.getAll();
	}
}
