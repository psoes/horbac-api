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

import com.uds.horbac.core.emp_ownershipInfo.dto.VehiculeTypeDTO;
import com.uds.horbac.core.emp_ownershipInfo.entities.VehiculeType;
import com.uds.horbac.core.emp_ownershipInfo.service.VehiculeTypeService;


@RestController
@RequestMapping(produces="application/json")
public class VehiculeTypeController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private VehiculeTypeService vehiculeTypeService;
	
	@GetMapping("/vehicule-type")
	@ResponseStatus(value=HttpStatus.OK)
	public List<VehiculeTypeDTO> getVehiculeType() {
		List<VehiculeType> vehiculeType = vehiculeTypeService.getAll();
		List<VehiculeTypeDTO> vehiculeTypeDTO = vehiculeType.stream()
					.map(elt -> modelMapper.map(elt, VehiculeTypeDTO.class))
					.collect(Collectors.toList());
		return vehiculeTypeDTO;
	}
	
	@GetMapping("/vehicule-type/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public VehiculeTypeDTO getVehiculeTypeById(@PathVariable Long id) {
		VehiculeType vehiculeType = vehiculeTypeService.getVehiculeType(id);
		return modelMapper.map(vehiculeType, VehiculeTypeDTO.class);
	}
	
	@PostMapping("/vehicule-type")
	@ResponseStatus(value=HttpStatus.OK)
	public VehiculeTypeDTO createVehiculeType(@RequestBody VehiculeTypeDTO vehiculeTypeDTO ) {
		VehiculeType vehiculeType = modelMapper.map(vehiculeTypeDTO, VehiculeType.class);
		return modelMapper.map(vehiculeTypeService.save(vehiculeType), VehiculeTypeDTO.class);
	}
	
	@PutMapping("/vehicule-type")
	@ResponseStatus(value=HttpStatus.OK)
	public VehiculeTypeDTO updatevehiculeType(@RequestBody VehiculeTypeDTO vehiculeTypeDTO ) {
		VehiculeType vehiculeType = modelMapper.map(vehiculeTypeDTO, VehiculeType.class);
		return modelMapper.map(vehiculeTypeService.save(vehiculeType), VehiculeTypeDTO.class);
	}
	
	@DeleteMapping(value = "/vehicule-type/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		vehiculeTypeService.delete(id);
	}
}
