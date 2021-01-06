package com.uds.horbac.core.service.emp_ownershipInfo;

import com.uds.horbac.core.dao.emp_ownershipInfo.BankAccountRepository;
import com.uds.horbac.core.entities.emp_ownershipInfo.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class BankAccountService {

	private BankAccountRepository bankAccountRepository;

	@Autowired
	public BankAccountService(BankAccountRepository bankAccountRepository) {
		this.bankAccountRepository = bankAccountRepository;
	}

}
