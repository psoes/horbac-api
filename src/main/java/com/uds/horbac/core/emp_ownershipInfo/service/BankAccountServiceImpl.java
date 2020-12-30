package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.emp_ownershipInfo.dao.BankAccountRepository;
import com.uds.horbac.core.emp_ownershipInfo.entities.BankAccount;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository bankAccountRepository;
	
	@Override
	public BankAccount save(BankAccount bankAccount) {
		return bankAccountRepository.save(bankAccount);
	}

	@Override
	public void delete(String code) {
		bankAccountRepository.deleteById(code);
	}

	@Override
	public List<BankAccount> getAll() {
		return bankAccountRepository.findAll();
	}

	@Override
	public BankAccount getBankAccount(String code) {
		return bankAccountRepository.getOne(code);
	}

}
