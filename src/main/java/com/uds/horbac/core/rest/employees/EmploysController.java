package com.uds.horbac.core.rest.employees;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

import com.uds.horbac.core.dto.employees.EmploysDTO;
import com.uds.horbac.core.entities.employees.Employs;
import com.uds.horbac.core.service.employees.EmploysService;

@RestController
public class EmploysController {
	
	protected @Autowired EmploysService service;    
    protected @Autowired ModelMapper modelMapper;
    
    @RequestMapping(value = "/employs", method = GET)
    public List<EmploysDTO> getAll(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return service.getAll().stream()
				.map(emp -> modelMapper.map(emp, EmploysDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/employs/{id}")
   	@ResponseStatus(value=HttpStatus.OK)
   	public EmploysDTO getEmploys(@PathVariable Long id){
   		return modelMapper.map(service.getOne(id), EmploysDTO.class);
   	}
   	
   	@PostMapping("/employs")
   	@ResponseStatus(value=HttpStatus.CREATED)
   	public EmploysDTO  createEmploys(@RequestBody EmploysDTO emp){		
   		Employs empl = modelMapper.map(emp, Employs.class);   		
   		return modelMapper.map(service.create(empl), EmploysDTO.class);
   	}
   	
   	@PutMapping("/employs")
   	@ResponseStatus(value=HttpStatus.OK)
   	public EmploysDTO updateEmploys(@Valid @RequestBody EmploysDTO empDTO) {		
   		Employs app = modelMapper.map(empDTO, Employs.class);		
   		return modelMapper.map(service.create(app), EmploysDTO.class);
   	}   	
   	@DeleteMapping(value = "/employs/{id}")
   	@ResponseStatus(value=HttpStatus.OK)
   	public void delete(@PathVariable Long id){
   		service.delete(id);
   	}
}
