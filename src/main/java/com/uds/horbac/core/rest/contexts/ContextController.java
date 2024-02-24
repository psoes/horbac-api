package com.uds.horbac.core.rest.contexts;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.uds.horbac.core.annotations.IsAllowed;
import com.uds.horbac.core.security.ActivityType;
import com.uds.horbac.core.security.ViewType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
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

import com.uds.horbac.core.dto.contexts.ContextDTO;
import com.uds.horbac.core.entities.contexts.Context;
import com.uds.horbac.core.service.contexts.ContextService;

@RestController
public class ContextController {
	protected @Autowired ContextService service;    
    protected @Autowired ModelMapper modelMapper;
    
    @GetMapping(value = "/contexts")
	@IsAllowed(activity = ActivityType.VIEW, view = ViewType.CONTEXTS)
    public List<ContextDTO> getAll(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return service.getAll().stream()
				.map(ctx -> modelMapper.map(ctx, ContextDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/contexts/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	@IsAllowed(activity = ActivityType.VIEW, view = ViewType.CONTEXTS)
	public ContextDTO getContextById(@PathVariable Long id){
		return modelMapper.map(service.getContext(id), ContextDTO.class);
	}
	
	@PostMapping("/contexts")
	@ResponseStatus(value=HttpStatus.CREATED)
	@IsAllowed(activity = ActivityType.CREATE, view = ViewType.CONTEXTS)
	public ContextDTO createContext(@Valid @RequestBody ContextDTO ctxDTO){
		//if(orgDTO.getUrl() != null) {orgDTO.setUrl(new URL(orgDTO.getUrl()));
		Context ctx = modelMapper.map(ctxDTO, Context.class);
		
		return modelMapper.map(service.save(ctx), ContextDTO.class);
	}
	
	@PutMapping("/contexts/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	@IsAllowed(activity = ActivityType.UPDATE, view = ViewType.CONTEXTS)
	public ContextDTO  updateContext(@PathVariable("id") Long id, @Valid @RequestBody ContextDTO ctxDTO) {		
		if(service.getContext(id) == null) {
			throw new ApplicationContextException("object not found");
		}
		Context ctx = modelMapper.map(ctxDTO, Context.class);		
		return modelMapper.map(service.save(ctx), ContextDTO.class);
	}
	
	@DeleteMapping(value = "/contexts/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	@IsAllowed(activity = ActivityType.DELETE, view = ViewType.CONTEXTS)
	public void delete(@PathVariable Long id){
		service.delete(id);
	}
}
