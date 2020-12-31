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

import com.uds.horbac.core.emp_ownershipInfo.dto.RepairerSpecialityDTO;
import com.uds.horbac.core.emp_ownershipInfo.entities.RepairerSpeciality;
import com.uds.horbac.core.emp_ownershipInfo.service.RepairerSpecialityService;

@RestController
@RequestMapping(produces="application/json")
public class RepairerSpecialityController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private RepairerSpecialityService repairerSpecialityService;
	
	@GetMapping("/repairer-specialities")
	@ResponseStatus(value=HttpStatus.OK)
	public List<RepairerSpecialityDTO> getRepairerSpecialities() {
		List<RepairerSpeciality> repairerSpeciality = repairerSpecialityService.getAll();
		List<RepairerSpecialityDTO> repairerSpecialityDTO = repairerSpeciality.stream()
					.map(elt -> modelMapper.map(elt, RepairerSpecialityDTO.class))
					.collect(Collectors.toList());
		return repairerSpecialityDTO;
	}
	
	@GetMapping("/repairer-specialities/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public RepairerSpecialityDTO getRepairerSpecialityById(@PathVariable Long id) {
		RepairerSpeciality repairerSpeciality = repairerSpecialityService.getRepairerSpeciality(id);
		return modelMapper.map(repairerSpeciality, RepairerSpecialityDTO.class);
	}
	
	@PostMapping("/repairer-specialities")
	@ResponseStatus(value=HttpStatus.OK)
	public RepairerSpecialityDTO createRepairerSpeciality(@RequestBody RepairerSpecialityDTO repairerSpecialityDTO ) {
		RepairerSpeciality repairerSpeciality = modelMapper.map(repairerSpecialityDTO, RepairerSpeciality.class);
		return modelMapper.map(repairerSpecialityService.save(repairerSpeciality), RepairerSpecialityDTO.class);
	}
	
	@PutMapping("/repairer-specialities")
	@ResponseStatus(value=HttpStatus.OK)
	public RepairerSpecialityDTO updateRepairerSpeciality(@RequestBody RepairerSpecialityDTO repairerSpecialityDTO ) {
		RepairerSpeciality repairerSpeciality = modelMapper.map(repairerSpecialityDTO, RepairerSpeciality.class);
		return modelMapper.map(repairerSpecialityService.save(repairerSpeciality), RepairerSpecialityDTO.class);
	}
	
	@DeleteMapping(value = "/repairer-specialities/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		repairerSpecialityService.delete(id);
	}
}
