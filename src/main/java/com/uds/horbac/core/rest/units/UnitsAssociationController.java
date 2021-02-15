package com.uds.horbac.core.rest.units;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.contexts.DefineDTO;
import com.uds.horbac.core.dto.units.PlaceUnderDTO;
import com.uds.horbac.core.dto.units.SubordinateDTO;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.units.OrgTree;
import com.uds.horbac.core.entities.units.PlaceUnder;
import com.uds.horbac.core.entities.units.Subordinate;
import com.uds.horbac.core.exceptions.ApiException;
import com.uds.horbac.core.service.organizations.OrganizationService;
import com.uds.horbac.core.service.units.OrgTreeService;
import com.uds.horbac.core.service.units.PlaceUnderService;
import com.uds.horbac.core.service.units.SubordinateService;

@RestController
public class UnitsAssociationController {	
	protected @Autowired SubordinateService subService;  
	protected @Autowired PlaceUnderService underService;
	protected @Autowired OrgTreeService orgTreeService;	
	protected @Autowired OrganizationService orgService;
	
    protected @Autowired ModelMapper modelMapper;
    
    @GetMapping(value = "/place-unders")
    public List<PlaceUnderDTO> getAllPlaceUnders(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return underService.getAll().stream()
				.map(def -> modelMapper.map(def, PlaceUnderDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/place-unders/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public PlaceUnderDTO getOnePlaceUnderById(@PathVariable Long id){
		return modelMapper.map(underService.getPlaceUnder(id), PlaceUnderDTO.class);
	}
	
	@PostMapping("/place-unders")
	@ResponseStatus(value=HttpStatus.CREATED)
	public PlaceUnderDTO create(@Valid @RequestBody PlaceUnderDTO defDTO){
		PlaceUnder def = modelMapper.map(defDTO, PlaceUnder.class);		
		return modelMapper.map(underService.save(def), PlaceUnderDTO.class);
	}
	
	@PutMapping("/place-unders")
	@ResponseStatus(value=HttpStatus.OK)
	public PlaceUnderDTO  updatePlaceUnder(@Valid @RequestBody PlaceUnderDTO defDTO) {		
		PlaceUnder def = modelMapper.map(defDTO, PlaceUnder.class);		
		return modelMapper.map(underService.save(def), PlaceUnderDTO.class);
	}
	
	@DeleteMapping(value = "/place-unders/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void deletePlaceUnder(@PathVariable Long id){
		underService.delete(id);
	}
	
	@PostMapping("/place-unders/many")
	@ResponseStatus(value=HttpStatus.CREATED)
	public List<PlaceUnderDTO> createManyPlaceUnders(@Valid @RequestBody List<PlaceUnderDTO> defDTOs){	
		List<PlaceUnder> subs = defDTOs.stream()
				.map(def -> modelMapper.map(def, PlaceUnder.class))
				.collect(Collectors.toList());
		
		return underService.saveAll(subs).stream()
				.map(def -> modelMapper.map(def, PlaceUnderDTO.class))
				.collect(Collectors.toList());
	}
	
	
	/*
	 * Subordinates entry points
	 */
	
	@GetMapping(value = "/subordinates")
    public List<SubordinateDTO> getAll(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return subService.getAll().stream()
				.map(def -> modelMapper.map(def, SubordinateDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/subordinates/{id}")
	public SubordinateDTO getOneById(@PathVariable Long id){
		return modelMapper.map(subService.getOne(id), SubordinateDTO.class);
	}
	
	@PostMapping("/subordinates")
	@ResponseStatus(value=HttpStatus.CREATED)
	public SubordinateDTO create(@Valid @RequestBody SubordinateDTO defDTO){
		Subordinate def = modelMapper.map(defDTO, Subordinate.class);
		def = subService.save(def);
		return modelMapper.map(def, SubordinateDTO.class);
	}
	
	@PostMapping("/subordinates/many")
	@ResponseStatus(value=HttpStatus.CREATED)
	public List<SubordinateDTO> createMany(@Valid @RequestBody List<SubordinateDTO> defDTOs){	
		List<Subordinate> subs = defDTOs.stream()
				.map(def -> modelMapper.map(def, Subordinate.class))
				.collect(Collectors.toList());
		
		return subService.saveAll(subs).stream()
				.map(def -> modelMapper.map(def, SubordinateDTO.class))
				.collect(Collectors.toList());
	}
	
	@PutMapping("/subordinates")
	@ResponseStatus(value=HttpStatus.OK)
	public SubordinateDTO  updateDefine(@Valid @RequestBody DefineDTO defDTO) {		
		Subordinate def = modelMapper.map(defDTO, Subordinate.class);		
		return modelMapper.map(subService.save(def), SubordinateDTO.class);
	}
	
	@DeleteMapping(value = "/subordinates/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		subService.delete(id);
	}
	
	@GetMapping(value = "/tree/organization/{id}")
	public ResponseEntity<OrgTree> getOrgTree(@PathVariable Long id){
		Organization org = orgService.getOrganization(id);
		if(org == null) {
			throw new ApiException("organization with id "+id+" not found");
		}	
		
		OrgTree res = orgTreeService.getOrgTree(org);
		traverse(res);
		return  ResponseEntity.ok(res);
	}
	
	private void traverse(OrgTree child) {
		for(OrgTree t: child.getChildren()) {
			System.out.println(child.getData().getName());
			System.out.println(t.getData().getName());
			traverse(t);
		}
		System.out.println("\n");
		
	}

}
