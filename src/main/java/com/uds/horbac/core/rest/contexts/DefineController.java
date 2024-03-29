package com.uds.horbac.core.rest.contexts;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.uds.horbac.core.annotations.IsAllowed;
import com.uds.horbac.core.security.ActivityType;
import com.uds.horbac.core.security.ViewType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.contexts.DefineDTO;
import com.uds.horbac.core.entities.contexts.Define;
import com.uds.horbac.core.exceptions.ApiException;
import com.uds.horbac.core.service.contexts.DefineService;

@RestController
public class DefineController {
	protected @Autowired DefineService service;    
    protected @Autowired ModelMapper modelMapper;
    
    @GetMapping(value = "/defines")
	@IsAllowed(activity = ActivityType.VIEW, view = ViewType.CONTEXTS)
    public List<DefineDTO> getAll(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return service.getAll().stream()
				.map(def -> modelMapper.map(def, DefineDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/defines/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	@IsAllowed(activity = ActivityType.VIEW, view = ViewType.CONTEXTS)
	public DefineDTO getDefineById(@PathVariable Long id){
		return modelMapper.map(service.getDefine(id), DefineDTO.class);
	}
	
	@PostMapping("/defines")
	@ResponseStatus(value=HttpStatus.CREATED)
	@IsAllowed(activity = ActivityType.ADMINISTER, view = ViewType.CONTEXTS)
	public DefineDTO createDefine(@Valid @RequestBody DefineDTO defDTO){
		Define def = modelMapper.map(defDTO, Define.class);
		
		return modelMapper.map(service.save(def), DefineDTO.class);
	}
	
	@PutMapping("/defines/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	@IsAllowed(activity = ActivityType.ADMINISTER, view = ViewType.CONTEXTS)
	public DefineDTO  updateDefine(@PathVariable("id") Long id,  @Valid @RequestBody DefineDTO defDTO) {		
		if(service.getDefine(id) == null) {
			throw new ApiException("DEFINE OF ID "+id+" NOT FOUND");
		}
		Define def = modelMapper.map(defDTO, Define.class);		
		return modelMapper.map(service.save(def), DefineDTO.class);
	}
	
	@DeleteMapping(value = "/defines/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	@IsAllowed(activity = ActivityType.ADMINISTER, view = ViewType.CONTEXTS)
	public void delete(@PathVariable Long id){
		service.delete(id);
	}
}
