package com.pedroaugust8.user.api.service;

import java.util.List;

import com.pedroaugust8.user.core.User;

public interface UserService {
	void addUser(User user);
	List<User> list();
}
