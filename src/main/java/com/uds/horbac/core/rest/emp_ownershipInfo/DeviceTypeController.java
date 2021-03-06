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

import com.uds.horbac.core.dto.emp_ownershipInfo.DeviceTypeDTO;
import com.uds.horbac.core.entities.emp_ownershipInfo.DeviceType;
import com.uds.horbac.core.service.emp_ownershipInfo.DeviceTypeService;

@RestController
@RequestMapping(produces="application/json")
public class DeviceTypeController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private DeviceTypeService deviceTypeService;
	
	@GetMapping("/device-types")
	@ResponseStatus(value=HttpStatus.OK)
	public List<DeviceTypeDTO> getDeviceTypes() {
		List<DeviceType> deviceType = deviceTypeService.getAll();
		List<DeviceTypeDTO> deviceTypeDTO = deviceType.stream()
					.map(elt -> modelMapper.map(elt, DeviceTypeDTO.class))
					.collect(Collectors.toList());
		return deviceTypeDTO;
	}
	
	@GetMapping("/device-types/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public DeviceTypeDTO getDeviceTypeById(@PathVariable Long id) {
		DeviceType deviceType = deviceTypeService.getDeviceType(id);
		return modelMapper.map(deviceType, DeviceTypeDTO.class);
	}
	
	@PostMapping("/device-types")
	@ResponseStatus(value=HttpStatus.OK)
	public DeviceTypeDTO createDeviceType(@Valid @RequestBody DeviceTypeDTO deviceTypeDTO ) {
		DeviceType deviceType = modelMapper.map(deviceTypeDTO, DeviceType.class);
		return modelMapper.map(deviceTypeService.save(deviceType), DeviceTypeDTO.class);
	}
	
	@PutMapping("/device-types")
	@ResponseStatus(value=HttpStatus.OK)
	public DeviceTypeDTO updateDeviceType(@Valid @RequestBody DeviceTypeDTO deviceTypeDTO ) {
		DeviceType deviceType = modelMapper.map(deviceTypeDTO, DeviceType.class);
		return modelMapper.map(deviceTypeService.save(deviceType), DeviceTypeDTO.class);
	}
	
	@DeleteMapping(value = "/device-types/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		deviceTypeService.delete(id);
	}
}
