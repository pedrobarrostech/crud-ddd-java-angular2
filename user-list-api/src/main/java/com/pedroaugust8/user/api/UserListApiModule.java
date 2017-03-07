package com.pedroaugust8.user.api;

import com.google.inject.servlet.ServletModule;

import com.pedroaugust8.user.api.service.UserService;
import com.pedroaugust8.user.api.service.UserServiceImpl;

public class UserListApiModule extends ServletModule{
	@Override
	protected void configureServlets() {
		bind(UserService.class).to(UserServiceImpl.class);
	}
}
