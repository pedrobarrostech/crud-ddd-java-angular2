package com.pedroaugust8.user.store;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

import com.pedroaugust8.user.store.cassandra.CassandraUserStore;
import com.pedroaugust8.user.store.service.UserStoreService;
import com.pedroaugust8.user.store.service.UserStoreServiceImpl;

public class UserStoreModule extends ServletModule{
	@Override
	protected void configureServlets() {
		bind(UserStore.class).to(CassandraUserStore.class);
		bind(UserStoreService.class).to(UserStoreServiceImpl.class);
	}
	
	@Provides
	public Session sessionProvider(){
		return Cluster.builder().addContactPoint("127.0.0.1").build().connect();
	}
}
