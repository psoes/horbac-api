package com.uds.horbac.core.rest.requests;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.requests.RequestDTO;
import com.uds.horbac.core.entities.requests.Request;
import com.uds.horbac.core.service.requests.RequestService;

@RestController
public class RequestController {
	protected @Autowired RequestService service;    
    protected @Autowired ModelMapper modelMapper;
    
    @GetMapping(value = "/requests")
    public List<RequestDTO> get(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return service.getAll().stream()
				.map(req -> modelMapper.map(req, RequestDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/requests/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public RequestDTO getRequestById(@PathVariable Long id){
		return modelMapper.map(service.getRequest(id), RequestDTO.class);
	}
	
	@PostMapping("/requests")
	@ResponseStatus(value=HttpStatus.CREATED)
	public RequestDTO createRequest(@Valid @RequestBody RequestDTO reqDTO){
		//if(orgDTO.getUrl() != null) {orgDTO.setUrl(new URL(orgDTO.getUrl()));
		Request req = modelMapper.map(reqDTO, Request.class);
		
		return modelMapper.map(service.save(req), RequestDTO.class);
	}
	
	@PutMapping("/requests")
	@ResponseStatus(value=HttpStatus.OK)
	public RequestDTO  updateRequest(@Valid @RequestBody RequestDTO reqDTO) {		
		Request req = modelMapper.map(reqDTO, Request.class);		
		return modelMapper.map(service.save(req), RequestDTO.class);
	}
	
	@DeleteMapping(value = "/requests/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		service.delete(id);
	}

}
