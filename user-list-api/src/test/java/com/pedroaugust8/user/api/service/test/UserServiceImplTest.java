package com.pedroaugust8.user.api.service.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pedroaugust8.user.api.service.UserServiceImpl;
import com.pedroaugust8.user.core.User;
import com.pedroaugust8.user.store.service.client.UserStoreServiceClient;

public class UserServiceImplTest {
	private static final User MY_MOVIE = new User();
	private UserStoreServiceClient userStoreClient;
	private List<User> mockList;
	private UserServiceImpl target;

	@Before
	public void setup(){
		mockList = mock(List.class);
		
		userStoreClient = mock(UserStoreServiceClient.class);
		when(userStoreClient.getAll()).thenReturn(mockList);
		
		target = new UserServiceImpl(userStoreClient);
	}
	
	@Test
	public void addUser(){
		target.addUser(MY_MOVIE);

		verify(userStoreClient).save(MY_MOVIE);
	}
	
	@Test
	public void list(){
		List<User> users = target.list();

		Assert.assertEquals(mockList, users);		
	}
}
