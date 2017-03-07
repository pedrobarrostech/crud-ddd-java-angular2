package com.pedroaugust8.user.api.service;

import java.util.List;

import javax.inject.Inject;

import com.pedroaugust8.user.core.User;
import com.pedroaugust8.user.store.service.client.UserStoreServiceClient;

public class UserServiceImpl implements UserService{

	private UserStoreServiceClient userClient;

	@Inject
	public UserServiceImpl(UserStoreServiceClient userClient){
		this.userClient = userClient;
	}

	public void addUser(User user) {
		userClient.save(user);
	}
	
	public List<User> list(){
		return this.userClient.getAll();
	}
}
