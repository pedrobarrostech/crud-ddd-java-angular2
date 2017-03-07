package com.pedroaugust8.user.api.resource.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pedroaugust8.user.api.resource.UserResource;
import com.pedroaugust8.user.api.service.UserService;
import com.pedroaugust8.user.core.User;

import static org.mockito.Mockito.*;

public class UserResourceTest {
	private UserService userService;
	private List<User> mockList;
	private UserResource target;
	
	@Before
	public void setUp(){
		mockList = (List<User>) mock(List.class);
		userService = mock(UserService.class);
		
		when(userService.list()).thenReturn(mockList);
		
		target = new UserResource(userService);
	}
	
	@Test
	public void save(){
		User user = new User();
		
		target.save(user);
		
		verify(userService).addUser(user);
	}
	
	@Test
	public void list(){
		List<User> actualList = target.list();
		
		Assert.assertEquals(mockList, actualList);
	}
}
