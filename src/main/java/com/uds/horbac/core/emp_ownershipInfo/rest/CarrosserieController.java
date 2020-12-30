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

import com.uds.horbac.core.emp_ownershipInfo.dto.CarrosserieDTO;
import com.uds.horbac.core.emp_ownershipInfo.entities.Carrosserie;
import com.uds.horbac.core.emp_ownershipInfo.service.CarrosserieService;

@RestController
@RequestMapping(produces="application/json")
public class CarrosserieController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private CarrosserieService carrosserieService;
	
	@GetMapping("/carrosserie")
	@ResponseStatus(value=HttpStatus.OK)
	public List<CarrosserieDTO> getCarrosserie() {
		List<Carrosserie> carrosserie = carrosserieService.getAll();
		List<CarrosserieDTO> carrosserieDTO = carrosserie.stream()
					.map(elt -> modelMapper.map(elt, CarrosserieDTO.class))
					.collect(Collectors.toList());
		return carrosserieDTO;
	}
	
	@GetMapping("/carrosserie/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public CarrosserieDTO getCarrosserieById(@PathVariable String id) {
		Carrosserie carrosserie = carrosserieService.getCarrosserie(id);
		return modelMapper.map(carrosserie, CarrosserieDTO.class);
	}
	
	@PostMapping("/carrosserie")
	@ResponseStatus(value=HttpStatus.OK)
	public CarrosserieDTO createCarrosserie(@RequestBody CarrosserieDTO carrosserieDTO ) {
		Carrosserie carrosserie = modelMapper.map(carrosserieDTO, Carrosserie.class);
		return modelMapper.map(carrosserieService.save(carrosserie), CarrosserieDTO.class);
	}
	
	@PutMapping("/carrosserie")
	@ResponseStatus(value=HttpStatus.OK)
	public CarrosserieDTO updateCarrosserie(@RequestBody CarrosserieDTO carrosserieDTO ) {
		Carrosserie carrosserie = modelMapper.map(carrosserieDTO, Carrosserie.class);
		return modelMapper.map(carrosserieService.save(carrosserie), CarrosserieDTO.class);
	}
	
	@DeleteMapping(value = "/carrosserie/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable String id) {
		carrosserieService.delete(id);
	}
}
