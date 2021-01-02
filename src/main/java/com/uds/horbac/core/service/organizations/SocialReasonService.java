package com.uds.horbac.core.service.organizations;

import java.util.List;

import com.uds.horbac.core.entities.organizations.SocialReason;

public interface SocialReasonService {
	/**
	 * save an socialReason
	 * @param socialReason the socialReason to save
	 * @return Return the saved socialReason
	 */
	public SocialReason save(SocialReason socialReason);
	
	/**
	 * delete an socialReason by id
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * get all socialReasons
	 * @return
	 */

	public List<SocialReason> getAll();
	
	/**
	 * find socialReason by Id
	 * @param id
	 * @return return the socialReason found or null;
	 */
	public SocialReason getsocialReason(Long id);

}
