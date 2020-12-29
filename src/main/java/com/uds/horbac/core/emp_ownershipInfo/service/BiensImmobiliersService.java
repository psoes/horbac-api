package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import com.uds.horbac.core.emp_ownershipInfo.entities.BiensImmobiliers;

public interface BiensImmobiliersService {
	
	/**
	 * Save a BiensImmobiliers 
	 * @param BiensImmobiliers the BiensImmobiliers to save 
	 * @return Return the saved BiensImmobiliers
	 */	
	public BiensImmobiliers save(BiensImmobiliers biensImmobiliers);
	
	/**
	 * delete a BiensImmobiliers 
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all BiensImmobiliers 
	 * @return Return the list BiensImmobiliers
	 */
	public List<BiensImmobiliers> getAll();
	
	/**
	 * find a BiensImmobiliers by Id
	 * @param id 
	 * @return Return the BiensImmobiliers found or null
	 */	
	public BiensImmobiliers getBiensImmobiliers(Long id);

}
