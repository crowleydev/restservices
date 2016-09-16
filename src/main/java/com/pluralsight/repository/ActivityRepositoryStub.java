package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.models.Activity;
import com.pluralsight.models.User;

public class ActivityRepositoryStub implements ActivityRepository {
	
	/* (non-Javadoc)
	 * @see com.pluralsight.repository.ActivityRepository#findAllActivities()
	 */
	public List<Activity> findAllActivities () {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity act1 = new Activity();
		Activity act2 = new Activity();
		
		act1.setDescription("swimming");
		act1.setDuration(25);
		
		act2.setDescription("fighting");
		act2.setDuration(120);
		
		activities.add(act1);
		activities.add(act2);
		
		return activities;
		
	}

	@Override
	public Activity findActivity(String activityId) {
		
		if (activityId.equals("7777")) {
			return null;
		}
		
		Activity act1 = new Activity();
		act1.setDescription("swimming");
		act1.setDuration(25);
		
		User user = new User();
		user.setName("mjau");
		user.setId("1234");
		
		act1.setUser(user);
		
		return act1;
	}

	@Override
	public void create(Activity act) {
		// TODO Insert to db
		
	}
	
	@Override
	public Activity update(Activity act) {
		// TODO Update db
		
		return act;
		
	}
	
	@Override
	public void delete(String activityId) {
		// TODO delete from db
		
	}

}
