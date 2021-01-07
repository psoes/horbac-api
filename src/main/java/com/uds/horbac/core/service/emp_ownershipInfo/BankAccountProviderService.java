package com.uds.horbac.core.service.emp_ownershipInfo;


import java.util.List;

import com.uds.horbac.core.entities.emp_ownershipInfo.BankAccountProvider;

public interface BankAccountProviderService {

	/**
	 * Save a Bank Account Provider 
	 * @param BankAccountProvider the BankAccountProvider to save 
	 * @return Return the saved BankAccountProvider
	 */	
	public BankAccountProvider save(BankAccountProvider bankAccountProvider);
	
	/**
	 * delete a Bank Account Provider
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all Bank Account Provider
	 * @return Return the list BankAccountProvider
	 */
	public List<BankAccountProvider> getAll();
	
	/**
	 * find a Bank Account Provider by Id
	 * @param id 
	 * @return Return the BankAccountProvider found or null
	 */	
	public BankAccountProvider getBankAccountProvider(Long id);
}

