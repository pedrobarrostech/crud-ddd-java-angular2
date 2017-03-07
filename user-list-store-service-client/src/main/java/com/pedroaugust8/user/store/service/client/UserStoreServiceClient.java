package com.pedroaugust8.user.store.service.client;

import java.util.List;

import com.pedroaugust8.user.core.User;
import feign.Headers;
import feign.RequestLine;

public interface UserStoreServiceClient {
	@RequestLine("POST /store/user")
	@Headers("Content-Type: application/json")
	void save(User user);
	
	@RequestLine("GET /store/user")
	List<User> getAll();
}
