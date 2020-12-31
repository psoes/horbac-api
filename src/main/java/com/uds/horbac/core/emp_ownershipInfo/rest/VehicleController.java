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

import com.uds.horbac.core.emp_ownershipInfo.dto.VehicleDTO;
import com.uds.horbac.core.emp_ownershipInfo.entities.Vehicle;
import com.uds.horbac.core.emp_ownershipInfo.service.VehicleService;

@RestController
@RequestMapping(produces="application/json")
public class VehicleController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/vehicles")
	@ResponseStatus(value=HttpStatus.OK)
	public List<VehicleDTO> getVehicles() {
		List<Vehicle> vehicle = vehicleService.getAll();
		List<VehicleDTO> vehicleDTO = vehicle.stream()
					.map(elt -> modelMapper.map(elt, VehicleDTO.class))
					.collect(Collectors.toList());
		return vehicleDTO;
	}
	
	@GetMapping("/vehicles/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public VehicleDTO getVehicleById(@PathVariable Long id) {
		Vehicle vehicle = vehicleService.getVehicle(id);
		return modelMapper.map(vehicle, VehicleDTO.class);
	}
	
	@PostMapping("/vehicles")
	@ResponseStatus(value=HttpStatus.OK)
	public VehicleDTO createVehicle(@RequestBody VehicleDTO vehicleDTO ) {
		Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
		return modelMapper.map(vehicleService.save(vehicle), VehicleDTO.class);
	}
	
	@PutMapping("/vehicles")
	@ResponseStatus(value=HttpStatus.OK)
	public VehicleDTO updateVehicle(@RequestBody VehicleDTO vehicleDTO ) {
		Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
		return modelMapper.map(vehicleService.save(vehicle), VehicleDTO.class);
	}
	
	@DeleteMapping(value = "/vehicles/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		vehicleService.delete(id);
	}
}
