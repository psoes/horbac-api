package com.uds.horbac.core.rest.activities;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.activities.ConsiderDTO;
import com.uds.horbac.core.entities.activities.Consider;
import com.uds.horbac.core.service.activities.ConsiderService;

@RestController
public class ConsiderController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private ConsiderService considerService;
	
	
	@GetMapping("/considers")
	@ResponseStatus(value=HttpStatus.OK)
	public List<ConsiderDTO> getconsiders() {
		List<Consider> considers = considerService.getAll();
		List<ConsiderDTO> dtos = considers.stream()
				.map(ac -> modelMapper.map(ac, ConsiderDTO.class))
				.collect(Collectors.toList());
		return dtos;
	}
	
	@GetMapping("/considers/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public ConsiderDTO getConsiderById(@PathVariable Long id){
		Consider Consider = considerService.getConsider(id);
		return modelMapper.map(Consider, ConsiderDTO.class);
	}
	
	@PostMapping("/considers")
	@ResponseStatus(value=HttpStatus.CREATED)
	public ConsiderDTO createConsider(@RequestBody ConsiderDTO ConsiderDTO){
		Consider Consider = modelMapper.map(ConsiderDTO, Consider.class);
		Consider respConsider = considerService.save(Consider);
		
		return modelMapper.map(respConsider, ConsiderDTO.class);
	}
	
	@PutMapping("/considers")
	@ResponseStatus(value=HttpStatus.OK)
	public ConsiderDTO updateConsider(@RequestBody ConsiderDTO ConsiderDTO) {
		Consider Consider = modelMapper.map(ConsiderDTO, Consider.class);
		Consider respConsider = considerService.save(Consider);
		
		return modelMapper.map(respConsider, ConsiderDTO.class);
	}
	
	@DeleteMapping(value = "/considers/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		considerService.delete(id);
	}
	
	@GetMapping("/considers/actions/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public List<ConsiderDTO> getConsiderByActionId(@PathVariable Long id){
		List<Consider> considers = considerService.getConsidersByActionId(id);
		List<ConsiderDTO> dtos = considers.stream()
				.map(ac -> modelMapper.map(ac, ConsiderDTO.class))
				.collect(Collectors.toList());
		return dtos;
	}
	@GetMapping("/considers/activities/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public List<ConsiderDTO> getConsiderByActivityId(@PathVariable Long id){
		List<Consider> considers = considerService.getConsidersByActivityId(id);
		List<ConsiderDTO> dtos = considers.stream()
				.map(ac -> modelMapper.map(ac, ConsiderDTO.class))
				.collect(Collectors.toList());
		return dtos;
	}
	
	@GetMapping("/considers/{idOrg}/{idAction}/{idActivity}")
	@ResponseStatus(value=HttpStatus.OK)
	public ConsiderDTO getConsiderById(@PathVariable Long idOrg, @PathVariable Long idAction, @PathVariable Long idActivity){
		Consider Consider = considerService.getConsidersByActionAndActivityAndOrg(idAction, idActivity, idOrg);
		return modelMapper.map(Consider, ConsiderDTO.class);
	}

}
