package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.emp_ownershipInfo.BankAccountProviderRepository;
import com.uds.horbac.core.entities.emp_ownershipInfo.BankAccountProvider;

@Service
public class BankAccountProviderServiceImpl implements BankAccountProviderService {

	@Autowired
	BankAccountProviderRepository bankAccountProviderRepository; 
	
	@Override
	public BankAccountProvider save(BankAccountProvider bankAccountProvider) {
		return bankAccountProviderRepository.save(bankAccountProvider);
	}

	@Override
	public void delete(Long id) {
		bankAccountProviderRepository.deleteById(id);
	}

	@Override
	public List<BankAccountProvider> getAll() {
		return bankAccountProviderRepository.findAll();
	}

	@Override
	public BankAccountProvider getBankAccountProvider(Long id) {
		return bankAccountProviderRepository.getOne(id);
	}

}
