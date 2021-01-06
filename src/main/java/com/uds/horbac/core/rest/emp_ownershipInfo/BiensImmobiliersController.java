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

import com.uds.horbac.core.dto.emp_ownershipInfo.BiensImmobiliersDTO;
import com.uds.horbac.core.entities.emp_ownershipInfo.BiensImmobiliers;
import com.uds.horbac.core.service.emp_ownershipInfo.BiensImmobiliersService;

@RestController
@RequestMapping(produces="application/json")
public class BiensImmobiliersController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private BiensImmobiliersService biensImmobiliersService;
	
	@GetMapping("/biens-immobiliers")
	@ResponseStatus(value=HttpStatus.OK)
	public List<BiensImmobiliersDTO> getBiensImmobiliers() {
		List<BiensImmobiliers> biensImmobiliers = biensImmobiliersService.getAll();
		List<BiensImmobiliersDTO> biensImmobiliersDTO = biensImmobiliers.stream()
					.map(elt -> modelMapper.map(elt, BiensImmobiliersDTO.class))
					.collect(Collectors.toList());
		return biensImmobiliersDTO;
	}
	
	@GetMapping("/biens-immobiliers/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public BiensImmobiliersDTO getBiensImmobiliersById(@PathVariable Long id) {
		BiensImmobiliers biensImmobiliers = biensImmobiliersService.getBiensImmobiliers(id);
		return modelMapper.map(biensImmobiliers, BiensImmobiliersDTO.class);
	}
	
	@PostMapping("/biens-immobiliers")
	@ResponseStatus(value=HttpStatus.OK)
	public BiensImmobiliersDTO createBiensImmobiliers(@Valid @RequestBody BiensImmobiliersDTO biensImmobiliersDTO ) {
		BiensImmobiliers biensImmobiliers = modelMapper.map(biensImmobiliersDTO, BiensImmobiliers.class);
		return modelMapper.map(biensImmobiliersService.save(biensImmobiliers), BiensImmobiliersDTO.class);
	}
	
	@PutMapping("/biens-immobiliers")
	@ResponseStatus(value=HttpStatus.OK)
	public BiensImmobiliersDTO updateBiensImmobiliers(@Valid @RequestBody BiensImmobiliersDTO biensImmobiliersDTO ) {
		BiensImmobiliers biensImmobiliers = modelMapper.map(biensImmobiliersDTO, BiensImmobiliers.class);
		return modelMapper.map(biensImmobiliersService.save(biensImmobiliers), BiensImmobiliersDTO.class);
	}
	
	@DeleteMapping(value = "/biens-immobiliers/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		biensImmobiliersService.delete(id);
	}
}
