package com.pedroaugust8.user.store.service.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pedroaugust8.user.core.User;
import com.pedroaugust8.user.store.UserStore;
import com.pedroaugust8.user.store.service.UserStoreServiceImpl;


public class UserStoreServiceImplTest {
	private List<User> mockList;
	private UserStore store;
	private UserStoreServiceImpl target;

	@Before
	public void setup(){
		mockList = mock(List.class);
		
		store = mock(UserStore.class);
		when(store.getAll()).thenReturn(mockList);
		
		target = new UserStoreServiceImpl(store);
	}
	
	@Test
	public void save(){
		User user = new User();
		
		target.save(user);
		
		verify(store).save(user);
	}
	
	@Test
	public void list(){
		List<User> actualList = target.getAll();
		
		Assert.assertEquals(mockList, actualList);
	}
}
