package com.pluralsight.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.pluralsight.models.Activity;

public class ActivityClientTest {
	
	@Test
	public void testDelete() {
		
		ActivityClient client = new ActivityClient();
		client.delete("1234");
		
		
	}
	
	@Test
	public void testPut () {
		
		Activity act = new Activity();
		act.setId("3580");
		act.setDescription("Yoga");
		act.setDuration(500);
		
		ActivityClient client = new ActivityClient();
		
		act = client.update(act);
		
		assertNotNull(act);
	}
	
	@Test
	public void testCreate () {
		
		ActivityClient client = new ActivityClient();
		
		Activity act = new Activity();
		act.setDescription("running");
		act.setDuration(50);
		
		act = client.create(act);
		
		assertNotNull(act);
	} 

	@Test
	public void testGet () {
		
		ActivityClient client = new ActivityClient();
		
		Activity act = client.get("1234");
		
		System.out.println(act);
		
		assertNotNull(act);
	}

	@Test
	public void testGetList () {
		
		ActivityClient client = new ActivityClient();
		
		List<Activity> activities = client.get();
		
		System.out.println(activities);
		
		assertNotNull(activities);
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithBadRequest () {
		
		ActivityClient client = new ActivityClient();
		
		client.get("123");
		
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithNotFound () {
		
		ActivityClient client = new ActivityClient();
		
		client.get("7777");
		
		
	}
	
	
}
