package com.uds.horbac.core.rest.emp_ownershipInfo;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.emp_ownershipInfo.WheelDTO;
import com.uds.horbac.core.entities.emp_ownershipInfo.Wheel;
import com.uds.horbac.core.service.emp_ownershipInfo.WheelService;


@RestController
@RequestMapping(produces="application/json")
public class WheelController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private WheelService wheelService;
	
	@GetMapping("/wheels")
	@ResponseStatus(value=HttpStatus.OK)
	public List<WheelDTO> getWheels() {
		List<Wheel> wheel = wheelService.getAll();
		List<WheelDTO> wheelDTO = wheel.stream()
					.map(elt -> modelMapper.map(elt, WheelDTO.class))
					.collect(Collectors.toList());
		return wheelDTO;
	}
	
	@GetMapping("/wheels/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public WheelDTO getWheelId(@PathVariable Long id) {
		Wheel wheel = wheelService.getWheel(id);
		return modelMapper.map(wheel, WheelDTO.class);
	}
	
	@PostMapping("/wheels")
	@ResponseStatus(value=HttpStatus.OK)
	public WheelDTO createWheel(@Valid @RequestBody WheelDTO wheelDTO ) {
		Wheel wheel = modelMapper.map(wheelDTO, Wheel.class);
		return modelMapper.map(wheelService.save(wheel), WheelDTO.class);
	}
	
	@PutMapping("/wheels")
	@ResponseStatus(value=HttpStatus.OK)
	public WheelDTO updateWheel(@Valid @RequestBody WheelDTO wheelDTO ) {
		Wheel wheel = modelMapper.map(wheelDTO, Wheel.class);
		return modelMapper.map(wheelService.save(wheel), WheelDTO.class);
	}
	
	@DeleteMapping(value = "/wheels/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		wheelService.delete(id);
	}
}
