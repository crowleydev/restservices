package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.models.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void create(Activity act);

	Activity update(Activity act);

	void delete(String activityId);


}