package com.uds.horbac.core.activities.service;

import java.util.List;

import com.uds.horbac.core.activities.entities.Activity;

public interface ActivityService {
	
	/**
	 * save an activity
	 * @param activity the activity to save
	 * @return Return the saved activity
	 */
	public Activity save(Activity activity);
	
	/**
	 * delete an activity by id
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * get all activities
	 * @return
	 */

	public List<Activity> getAll();
	
	/**
	 * find activity by Id
	 * @param id
	 * @return return the activity found or null;
	 */
	public Activity getActivity(Long id);
}
