package com.uds.horbac.core.service.activities;

import java.util.List;

import com.uds.horbac.core.entities.activities.Action;

public interface ActionService {
	/**
	 * save an action
	 * @param action the action to save
	 * @return Return the saved action
	 */
	public Action save(Action action);
	
	/**
	 * delete an action by id
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * get all activities
	 * @return
	 */

	public List<Action> getAll();
	
	/**
	 * find action by Id
	 * @param id
	 * @return return the action found or null;
	 */
	public Action getAction(Long id);

}
