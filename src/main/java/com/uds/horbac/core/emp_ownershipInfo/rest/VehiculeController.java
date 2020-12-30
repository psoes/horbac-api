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

import com.uds.horbac.core.emp_ownershipInfo.dto.VehiculeDTO;
import com.uds.horbac.core.emp_ownershipInfo.entities.Vehicle;
import com.uds.horbac.core.emp_ownershipInfo.service.VehiculeService;

@RestController
@RequestMapping(produces="application/json")
public class VehiculeController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private VehiculeService vehiculeService;
	
	@GetMapping("/vehicule")
	@ResponseStatus(value=HttpStatus.OK)
	public List<VehiculeDTO> getVehicule() {
		List<Vehicle> vehicule = vehiculeService.getAll();
		List<VehiculeDTO> vehiculeDTO = vehicule.stream()
					.map(elt -> modelMapper.map(elt, VehiculeDTO.class))
					.collect(Collectors.toList());
		return vehiculeDTO;
	}
	
	@GetMapping("/vehicule/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public VehiculeDTO getVehiculeById(@PathVariable Long id) {
		Vehicle vehicule = vehiculeService.getVehicule(id);
		return modelMapper.map(vehicule, VehiculeDTO.class);
	}
	
	@PostMapping("/vehicule")
	@ResponseStatus(value=HttpStatus.OK)
	public VehiculeDTO createVehicule(@RequestBody VehiculeDTO vehiculeDTO ) {
		Vehicle vehicule = modelMapper.map(vehiculeDTO, Vehicle.class);
		return modelMapper.map(vehiculeService.save(vehicule), VehiculeDTO.class);
	}
	
	@PutMapping("/vehicule")
	@ResponseStatus(value=HttpStatus.OK)
	public VehiculeDTO updateVehicule(@RequestBody VehiculeDTO vehiculeDTO ) {
		Vehicle vehicule = modelMapper.map(vehiculeDTO, Vehicle.class);
		return modelMapper.map(vehiculeService.save(vehicule), VehiculeDTO.class);
	}
	
	@DeleteMapping(value = "/vehicule/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		vehiculeService.delete(id);
	}
}
