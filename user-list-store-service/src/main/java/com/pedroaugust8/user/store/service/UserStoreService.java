package com.pedroaugust8.user.store.service;

import java.util.List;

import com.pedroaugust8.user.core.User;

public interface UserStoreService {
	void save(User user);
	List<User> getAll();
}