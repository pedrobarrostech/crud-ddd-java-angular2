package com.pedroaugust8.user.store.service;

import java.util.List;

import javax.inject.Inject;

import com.pedroaugust8.user.core.User;
import com.pedroaugust8.user.store.UserStore;

public class UserStoreServiceImpl implements UserStoreService {
	private final UserStore store;
	
	@Inject
	public UserStoreServiceImpl(UserStore store){
		this.store = store;
	}
	
	public void save(User user){
		this.store.save(user);
	}

	@Override
	public List<User> getAll() {
		return this.store.getAll();
	}
}
