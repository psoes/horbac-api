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

import com.uds.horbac.core.emp_ownershipInfo.dto.BankAccountDTO;
import com.uds.horbac.core.emp_ownershipInfo.entities.BankAccount;
import com.uds.horbac.core.emp_ownershipInfo.service.BankAccountService;

@RestController
@RequestMapping(produces="application/json")
public class BankAccountController {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@GetMapping("/bank-account")
	@ResponseStatus(value=HttpStatus.OK)
	public List<BankAccountDTO> getBankAccount() {
		List<BankAccount> bankAccount = bankAccountService.getAll();
		List<BankAccountDTO> bankAccountDTO = bankAccount.stream()
					.map(elt -> modelMapper.map(elt, BankAccountDTO.class))
					.collect(Collectors.toList());
		return bankAccountDTO;
	}
	
	@GetMapping("/bank-account/{code}")
	@ResponseStatus(value=HttpStatus.OK)
	public BankAccountDTO getBankAccountByCode(@PathVariable String code) {
		BankAccount bankAccount = bankAccountService.getBankAccount(code);
		return modelMapper.map(bankAccount, BankAccountDTO.class);
	}
	
	@PostMapping("/bank-account")
	@ResponseStatus(value=HttpStatus.OK)
	public BankAccountDTO createBankAccount(@RequestBody BankAccountDTO bankAccountDTO ) {
		BankAccount bankAccount = modelMapper.map(bankAccountDTO, BankAccount.class);
		return modelMapper.map(bankAccountService.save(bankAccount), BankAccountDTO.class);
	}
	
	@PutMapping("/bank-account")
	@ResponseStatus(value=HttpStatus.OK)
	public BankAccountDTO updateBankAccount(@RequestBody BankAccountDTO bankAccountDTO ) {
		BankAccount bankAccount = modelMapper.map(bankAccountDTO, BankAccount.class);
		return modelMapper.map(bankAccountService.save(bankAccount), BankAccountDTO.class);
	}
	
	@DeleteMapping(value = "/bank-account/{code}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable String code) {
		bankAccountService.delete(code);
	}
}
