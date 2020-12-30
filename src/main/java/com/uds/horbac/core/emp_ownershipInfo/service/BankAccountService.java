package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import com.uds.horbac.core.emp_ownershipInfo.entities.BankAccount;

public interface BankAccountService {

	/**
	 * Save a Bank Account 
	 * @param BankAccount the BankAccount to save 
	 * @return Return the saved BankAccount
	 */	
	public BankAccount save(BankAccount bankAccount);
	
	/**
	 * delete a Bank Account 
	 * @param code
	 * @return 
	 */	
	public void delete(String code); 
	
	/**
	 * get all Bank Account 
	 * @return Return the list of BankAccount
	 */
	public List<BankAccount> getAll();
	
	/**
	 * find a Bank Account by code
	 * @param code
	 * @return Return the BankAccount found or null
	 */	
	public BankAccount getBankAccount(String code);
}
