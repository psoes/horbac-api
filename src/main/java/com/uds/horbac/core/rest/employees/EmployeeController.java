package com.uds.horbac.core.rest.employees;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dao.emp_personalInfo.AddressRepository;
import com.uds.horbac.core.dao.emp_personalInfo.EmailRepository;
import com.uds.horbac.core.dao.emp_personalInfo.PhoneNumberRepository;
import com.uds.horbac.core.dto.employees.EmployeeCrudDTO;
import com.uds.horbac.core.dto.employees.EmployeeDTO;
import com.uds.horbac.core.entities.emp_personalInfo.Address;
import com.uds.horbac.core.entities.emp_personalInfo.Email;
import com.uds.horbac.core.entities.emp_personalInfo.PhoneNumber;
import com.uds.horbac.core.entities.employees.Employee;
import com.uds.horbac.core.service.employees.EmployeeService;

@RestController
public class EmployeeController {
	
	protected @Autowired EmployeeService service;    
    protected @Autowired ModelMapper modelMapper;
    protected @Autowired EmailRepository emailRepository;
    protected @Autowired PhoneNumberRepository phoneNumberRepository;
    protected @Autowired AddressRepository addressRepository;
    
    @RequestMapping(value = "/employees", method = GET)
    public List<EmployeeDTO> getAll(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return service.getAll().stream()
				.map(emp -> modelMapper.map(emp, EmployeeDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/employees/{id}")
   	@ResponseStatus(value=HttpStatus.OK)
   	public EmployeeDTO getEmployee(@PathVariable Long id){
   		return modelMapper.map(service.getEmployee(id), EmployeeDTO.class);
   	}
   	
   	@PostMapping("/employees")
   	@ResponseStatus(value=HttpStatus.CREATED)
   	public EmployeeCrudDTO createEmployee(@Valid @RequestBody EmployeeCrudDTO employeeDTO){
   		List<Email> emails = new ArrayList<Email>();
   		List<PhoneNumber> phones = new ArrayList<PhoneNumber>();
   		List<Address> addresses = new ArrayList<Address>();
   		if(employeeDTO.getEmails()!= null && !employeeDTO.getEmails().isEmpty()) {
   			emails = this.emailRepository.saveAll(employeeDTO.getEmails().stream().map(
   					em -> modelMapper.map(em, Email.class)).collect(Collectors.toList()));
   		}
   		if(employeeDTO.getPhones()!= null &&  !employeeDTO.getPhones().isEmpty()) {
   			phones = this.phoneNumberRepository.saveAll(employeeDTO.getPhones().stream().map(
   					phone -> modelMapper.map(phone, PhoneNumber.class)).collect(Collectors.toList()));
   		}
   		if(employeeDTO.getAddresses()!= null && employeeDTO.getAddresses().isEmpty()) {
   			addresses = this.addressRepository.saveAll(employeeDTO.getAddresses().stream().map(
   					adr -> modelMapper.map(adr, Address.class)).collect(Collectors.toList()));
   		}
   		Employee emp = modelMapper.map(employeeDTO, Employee.class); 
   		emp.setEmails(emails);
   		emp.setPhones(phones);
   		emp.setAddresses(addresses);
   		return modelMapper.map(service.save(emp), EmployeeCrudDTO.class);
   	}
   	
   	@PutMapping("/employees")
   	@ResponseStatus(value=HttpStatus.OK)
   	public EmployeeDTO  updateEmployee(@Valid @RequestBody EmployeeCrudDTO employeeDTO) {		
   		Employee emp = modelMapper.map(employeeDTO, Employee.class);		
   		return modelMapper.map(service.save(emp), EmployeeDTO.class);
   	}
   	
   	@DeleteMapping(value = "/employees/{id}")
   	@ResponseStatus(value=HttpStatus.OK)
   	public void delete(@PathVariable Long id){
   		service.delete(id);
   	}
}
