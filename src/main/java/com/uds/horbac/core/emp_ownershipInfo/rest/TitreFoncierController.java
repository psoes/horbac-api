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

import com.uds.horbac.core.emp_ownershipInfo.dto.TitreFoncierDTO;
import com.uds.horbac.core.emp_ownershipInfo.entities.TitreFoncier;
import com.uds.horbac.core.emp_ownershipInfo.service.TitreFoncierService;

@RestController
@RequestMapping(produces="application/json")
public class TitreFoncierController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private TitreFoncierService titreFoncierService;
	
	@GetMapping("/titre-foncier")
	@ResponseStatus(value=HttpStatus.OK)
	public List<TitreFoncierDTO> getTitreFoncier() {
		List<TitreFoncier> titreFoncier = titreFoncierService.getAll();
		List<TitreFoncierDTO> titreFoncierDTO = titreFoncier.stream()
					.map(elt -> modelMapper.map(elt, TitreFoncierDTO.class))
					.collect(Collectors.toList());
		return titreFoncierDTO;
	}
	
	@GetMapping("/titre-foncier/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public TitreFoncierDTO getTitreFoncierById(@PathVariable Long id) {
		TitreFoncier titreFoncier = titreFoncierService.getTitreFoncier(id);
		return modelMapper.map(titreFoncier, TitreFoncierDTO.class);
	}
	
	@PostMapping("/titre-foncier")
	@ResponseStatus(value=HttpStatus.OK)
	public TitreFoncierDTO createTitreFoncier(@RequestBody TitreFoncierDTO titreFoncierDTO ) {
		TitreFoncier titreFoncier = modelMapper.map(titreFoncierDTO, TitreFoncier.class);
		return modelMapper.map(titreFoncierService.save(titreFoncier), TitreFoncierDTO.class);
	}
	
	@PutMapping("/titre-foncier")
	@ResponseStatus(value=HttpStatus.OK)
	public TitreFoncierDTO updateTitreFoncier(@RequestBody TitreFoncierDTO titreFoncierDTO ) {
		TitreFoncier titreFoncier = modelMapper.map(titreFoncierDTO, TitreFoncier.class);
		return modelMapper.map(titreFoncierService.save(titreFoncier), TitreFoncierDTO.class);
	}
	
	@DeleteMapping(value = "/titre-foncier/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		titreFoncierService.delete(id);
	}
}
