package com.pedroaugust8.user.store.resource.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pedroaugust8.user.core.User;
import com.pedroaugust8.user.store.resource.UserStoreResource;
import com.pedroaugust8.user.store.service.UserStoreService;

public class UserStoreResourceTest {
	private UserStoreService service;
	private UserStoreResource target;
	private List<User> mockList;

	@Before
	public void setup(){
		mockList = mock(List.class);
		
		service = mock(UserStoreService.class);
		when(service.getAll()).thenReturn(mockList);
		
		target = new UserStoreResource(service);
	}
	
	@Test
	public void save(){
		User user = new User();
		
		target.save(user);
		
		verify(service).save(user);
	}
	
	@Test
	public void list(){
		List<User> actualList = target.list();
		
		Assert.assertEquals(mockList, actualList);
	}
}
