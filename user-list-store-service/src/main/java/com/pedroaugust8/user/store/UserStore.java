package com.pedroaugust8.user.store;

import java.util.List;

import com.pedroaugust8.user.core.User;


public interface UserStore {
	void save(User user);
	List<User> getAll();
}
