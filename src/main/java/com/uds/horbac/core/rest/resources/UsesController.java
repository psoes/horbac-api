package com.uds.horbac.core.rest.resources;

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

import com.uds.horbac.core.dto.resources.UsesDTO;
import com.uds.horbac.core.entities.resources.Uses;
import com.uds.horbac.core.service.resources.UsesService;

/**
 * The default REST controller logic
 * @author Fidele
 */
@RestController
public class UsesController {
    
    protected @Autowired UsesService service;    
    protected @Autowired ModelMapper modelMapper;
    
    @GetMapping(value = "/uses")
    public List<UsesDTO> get(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return service.getAll().stream()
				.map(clt -> modelMapper.map(clt, UsesDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/uses/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public UsesDTO getUsesById(@PathVariable Long id){
		return modelMapper.map(service.getUses(id), UsesDTO.class);
	}
	
	@PostMapping("/uses")
	@ResponseStatus(value=HttpStatus.CREATED)
	public UsesDTO createUses(@Valid @RequestBody UsesDTO usesDTO){
		//if(orgDTO.getUrl() != null) {orgDTO.setUrl(new URL(orgDTO.getUrl()));
		Uses clt = modelMapper.map(usesDTO, Uses.class);
		
		return modelMapper.map(service.save(clt), UsesDTO.class);
	}
	
	@PutMapping("/uses")
	@ResponseStatus(value=HttpStatus.OK)
	public UsesDTO  updateUses(@Valid @RequestBody UsesDTO usesDTO) {		
		Uses clt = modelMapper.map(usesDTO, Uses.class);		
		return modelMapper.map(service.save(clt), UsesDTO.class);
	}
	
	@DeleteMapping(value = "/uses/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		service.delete(id);
	}
}