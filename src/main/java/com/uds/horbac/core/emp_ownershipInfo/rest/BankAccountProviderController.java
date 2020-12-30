package com.uds.horbac.core.emp_ownershipInfo.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.emp_ownershipInfo.dto.BankAccountProviderDTO;
import com.uds.horbac.core.emp_ownershipInfo.entities.BankAccountProvider;
import com.uds.horbac.core.emp_ownershipInfo.service.BankAccountProviderService;

@RestController
@RequestMapping(produces="application/json")
public class BankAccountProviderController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private BankAccountProviderService bankAccountProviderService;
	
	@GetMapping("/bank-account-provider")
	@ResponseStatus(value=HttpStatus.OK)
	public List<BankAccountProviderDTO> getBankAccountProvider() {
		List<BankAccountProvider> bankAccountProvider = bankAccountProviderService.getAll();
		List<BankAccountProviderDTO> bankAccountProviderDTO = bankAccountProvider.stream()
					.map(elt -> modelMapper.map(elt, BankAccountProviderDTO.class))
					.collect(Collectors.toList());
		return bankAccountProviderDTO;
	}
	
	@GetMapping("/bank-account-provider/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public BankAccountProviderDTO getBankAccountProviderById(@PathVariable Long id) {
		BankAccountProvider bankAccountProvider = bankAccountProviderService.getBankAccountProvider(id);
		return modelMapper.map(bankAccountProvider, BankAccountProviderDTO.class);
	}
	
	@PostMapping("/bank-account-provider")
	@ResponseStatus(value=HttpStatus.OK)
	public BankAccountProviderDTO createBankAccountProvider(@RequestBody BankAccountProviderDTO bankAccountProviderDTO ) {
		BankAccountProvider bankAccountProvider = modelMapper.map(bankAccountProviderDTO, BankAccountProvider.class);
		return modelMapper.map(bankAccountProviderService.save(bankAccountProvider), BankAccountProviderDTO.class);
	}
	
	@PutMapping("/bank-account-provider")
	@ResponseStatus(value=HttpStatus.OK)
	public BankAccountProviderDTO updateBankAccountProvider(@RequestBody BankAccountProviderDTO bankAccountProviderDTO ) {
		BankAccountProvider bankAccountProvider = modelMapper.map(bankAccountProviderDTO, BankAccountProvider.class);
		return modelMapper.map(bankAccountProviderService.save(bankAccountProvider), BankAccountProviderDTO.class);
	}
	
	@DeleteMapping(value = "/bank-account-provider/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		bankAccountProviderService.delete(id);
	}
}
