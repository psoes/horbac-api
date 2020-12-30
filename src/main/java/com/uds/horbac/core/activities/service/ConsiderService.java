package com.uds.horbac.core.activities.service;

import java.util.List;

import com.uds.horbac.core.activities.entities.Consider;

public interface ConsiderService {
	/**
	 * save an consider
	 * @param consider the consider to save
	 * @return Return the saved consider
	 */
	public Consider save(Consider consider);
	
	/**
	 * delete an consider by id
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * get all considers
	 * @return
	 */

	public List<Consider> getAll();
	
	/**
	 * find consider by Id
	 * @param id
	 * @return return the consider found or null;
	 */
	public Consider getConsider(Long id);
	
	/**
	 * find considers by action
	 * @param id
	 * @return return the consider found or null;
	 */
	public List<Consider> getConsidersByActionId(Long id);
	
	/**
	 * find considers by action and activity
	 * @param id
	 * @return return the consider found or null;
	 */
	public Consider getConsidersByActionAndActivityAndOrg(Long idAction, Long idActivity, Long idOrg);
	
	/**
	 * find considers by activity
	 * @param id
	 * @return return the consider found or null;
	 */
	public List<Consider> getConsidersByActivityId(Long id);

}
