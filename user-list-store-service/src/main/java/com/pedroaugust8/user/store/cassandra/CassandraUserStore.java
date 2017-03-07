package com.pedroaugust8.user.store.cassandra;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.utils.UUIDs;

import com.pedroaugust8.user.core.User;
import com.pedroaugust8.user.store.UserStore;

public class CassandraUserStore implements UserStore {

	private Session session;
	
	@Inject
	public CassandraUserStore(Provider<Session> sessionProvider){
		this.session = sessionProvider.get();
	}
	
	@Override
	public void save(User user) {
		Insert insert = QueryBuilder.insertInto("UserListKeySpace", "User")
									.value("key", UUIDs.timeBased())
									.value("username", user.getUsername())
									.value("password", user.getPassword());
		
		session.execute(insert);
	}

	@Override
	public List<User> getAll() {
		Select select = QueryBuilder.select().from("UserListKeySpace", "User");
		
		ResultSet resultSet = session.execute(select);
		
		List<User> users = new ArrayList<User>();
		
		for(Row row: resultSet.all())
			users.add(createUserFromRow(row));
			
		return users;
	}
	
	private User createUserFromRow(Row row){
		User user = new User();
		user.setUsername(row.getString("username"));
		user.setPassword(row.getString("password"));
		return user;
	}

}
