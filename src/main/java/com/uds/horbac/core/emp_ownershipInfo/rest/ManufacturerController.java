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

import com.uds.horbac.core.emp_ownershipInfo.dto.ManufacturerDTO;
import com.uds.horbac.core.emp_ownershipInfo.entities.Manufacturer;
import com.uds.horbac.core.emp_ownershipInfo.service.ManufacturerService;

@RestController
@RequestMapping(produces="application/json")
public class ManufacturerController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@GetMapping("/manufacturerr")
	@ResponseStatus(value=HttpStatus.OK)
	public List<ManufacturerDTO> getManufacturer() {
		List<Manufacturer> manufacturer = manufacturerService.getAll();
		List<ManufacturerDTO> manufacturerDTO = manufacturer.stream()
					.map(elt -> modelMapper.map(elt, ManufacturerDTO.class))
					.collect(Collectors.toList());
		return manufacturerDTO;
	}
	
	@GetMapping("/manufacturerr/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public ManufacturerDTO getManufacturerById(@PathVariable Long id) {
		Manufacturer manufacturer = manufacturerService.getManufacturer(id);
		return modelMapper.map(manufacturer, ManufacturerDTO.class);
	}
	
	@PostMapping("/manufacturerr")
	@ResponseStatus(value=HttpStatus.OK)
	public ManufacturerDTO createManufacturer(@RequestBody ManufacturerDTO manufacturerDTO ) {
		Manufacturer manufacturer = modelMapper.map(manufacturerDTO, Manufacturer.class);
		return modelMapper.map(manufacturerService.save(manufacturer), ManufacturerDTO.class);
	}
	
	@PutMapping("/manufacturerr")
	@ResponseStatus(value=HttpStatus.OK)
	public ManufacturerDTO updateManufacturer(@RequestBody ManufacturerDTO manufacturerDTO ) {
		Manufacturer manufacturer = modelMapper.map(manufacturerDTO, Manufacturer.class);
		return modelMapper.map(manufacturerService.save(manufacturer), ManufacturerDTO.class);
	}
	
	@DeleteMapping(value = "/manufacturerr/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		manufacturerService.delete(id);
	}
}
