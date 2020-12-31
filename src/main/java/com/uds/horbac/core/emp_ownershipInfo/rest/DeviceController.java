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

import com.uds.horbac.core.emp_ownershipInfo.dto.DeviceDTO;
import com.uds.horbac.core.emp_ownershipInfo.entities.Device;
import com.uds.horbac.core.emp_ownershipInfo.service.DeviceService;

@RestController
@RequestMapping(produces="application/json")
public class DeviceController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private DeviceService deviceService;
	
	@GetMapping("/devices")
	@ResponseStatus(value=HttpStatus.OK)
	public List<DeviceDTO> getDevices() {
		List<Device> device = deviceService.getAll();
		List<DeviceDTO> deviceDTO = device.stream()
					.map(elt -> modelMapper.map(elt, DeviceDTO.class))
					.collect(Collectors.toList());
		return deviceDTO;
	}
	
	@GetMapping("/devices/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public DeviceDTO getDeviceById(@PathVariable Long id) {
		Device device = deviceService.getDevice(id);
		return modelMapper.map(device, DeviceDTO.class);
	}
	
	@PostMapping("/devices")
	@ResponseStatus(value=HttpStatus.OK)
	public DeviceDTO createDevice(@RequestBody DeviceDTO deviceDTO ) {
		Device device = modelMapper.map(deviceDTO, Device.class);
		return modelMapper.map(deviceService.save(device), DeviceDTO.class);
	}
	
	@PutMapping("/devices")
	@ResponseStatus(value=HttpStatus.OK)
	public DeviceDTO updateDevice(@RequestBody DeviceDTO deviceDTO ) {
		Device device = modelMapper.map(deviceDTO, Device.class);
		return modelMapper.map(deviceService.save(device), DeviceDTO.class);
	}
	
	@DeleteMapping(value = "/devices/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		deviceService.delete(id);
	}
}
