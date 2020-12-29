package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import com.uds.horbac.core.emp_ownershipInfo.entities.TitreFoncier;

public interface TitreFoncierService {
	
	/**
	 * Save a TitreFoncier
	 * @param TitreFoncier the TitreFoncier to save 
	 * @return Return the saved TitreFoncier
	 */	
	public TitreFoncier save(TitreFoncier titreFoncier);
	
	/**
	 * delete a TitreFoncier
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all TitreFoncier
	 * @return Return the list of TitreFoncier
	 */
	public List<TitreFoncier> getAll();
	
	/**
	 * find a TitreFoncier by Id
	 * @param id 
	 * @return Return the TitreFoncier found or null
	 */	
	public TitreFoncier getTitreFoncier(Long id);
}
