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

import com.uds.horbac.core.dto.employees.AppointsDTO;
import com.uds.horbac.core.entities.employees.Appoints;
import com.uds.horbac.core.service.employees.AppointsService;

@RestController
public class AppointController {
	
	protected @Autowired AppointsService service;    
    protected @Autowired ModelMapper modelMapper;
    
    @RequestMapping(value = "/appoints", method = GET)
    public List<AppointsDTO> getAll(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return service.getAll().stream()
				.map(emp -> modelMapper.map(emp, AppointsDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/appoints/{id}")
   	@ResponseStatus(value=HttpStatus.OK)
   	public AppointsDTO getAppoints(@PathVariable Long id){
   		return modelMapper.map(service.getOne(id), AppointsDTO.class);
   	}
   	
   	@PostMapping("/appoints")
   	@ResponseStatus(value=HttpStatus.CREATED)
   	public AppointsDTO  createAppoints(@RequestBody AppointsDTO appoints){		
   		Appoints appoint = modelMapper.map(appoints, Appoints.class);   		
   		return modelMapper.map(service.create(appoint), AppointsDTO.class);
   	}
   	
   	@PutMapping("/appoints")
   	@ResponseStatus(value=HttpStatus.OK)
   	public AppointsDTO  updateAppoints(@Valid @RequestBody AppointsDTO appDTO) {		
   		Appoints app = modelMapper.map(appDTO, Appoints.class);		
   		return modelMapper.map(service.create(app), AppointsDTO.class);
   	}
   	
   	@DeleteMapping(value = "/appoints/{id}")
   	@ResponseStatus(value=HttpStatus.OK)
   	public void delete(@PathVariable Long id){
   		service.delete(id);
   	}
}
