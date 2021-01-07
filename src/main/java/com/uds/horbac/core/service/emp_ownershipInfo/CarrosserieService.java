package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import com.uds.horbac.core.entities.emp_ownershipInfo.Carrosserie;

public interface CarrosserieService {
	
	/**
	 * Save a Carrosserie
	 * @param Carrosserie the Carrosseriet to save 
	 * @return Return the saved Carrosserie
	 */	
	public Carrosserie save(Carrosserie carrosserie);
	
	/**
	 * delete a Carrosserie
	 * @param id 
	 * @return 
	 */	
	public void delete(String id); 
	
	/**
	 * get all Carrosserie
	 * @return Return the list of Carrosserie
	 */
	public List<Carrosserie> getAll();
	
	/**
	 * find a Carrosserie by Id
	 * @param id 
	 * @return Return the Carrosserie found or null
	 */	
	public Carrosserie getCarrosserie(String id);
}
