package com.uds.horbac.core.rest.organizations;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.organizations.SocialReasonDTO;
import com.uds.horbac.core.entities.organizations.SocialReason;
import com.uds.horbac.core.service.organizations.SocialReasonService;

@RestController
public class SocialReasonController {
	
	@Autowired
	SocialReasonService socialReasonService;
	
	@Autowired
	ModelMapper modelMapper;

	
	@GetMapping("/social-reasons")
	@ResponseStatus(value=HttpStatus.OK)
	public List<SocialReasonDTO> getSocialReasons() {
		List<SocialReason> srs = socialReasonService.getAll();
		List<SocialReasonDTO> srso = srs.stream()
				.map(type -> modelMapper.map(type, SocialReasonDTO.class))
				.collect(Collectors.toList());
		return srso;
	}
	
	@GetMapping("/social-reasons/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public SocialReasonDTO getSocialReasonById(@PathVariable Long id){
		SocialReason sr = socialReasonService.getsocialReason(id);
			return modelMapper.map(sr, SocialReasonDTO.class);
	}
	
	@PostMapping("/social-reasons")
	@ResponseStatus(value=HttpStatus.CREATED)
	public SocialReasonDTO createSocialReason(@Validated @RequestBody SocialReasonDTO sro){
		
		SocialReason sr = modelMapper.map(sro, SocialReason.class);
		
		return modelMapper.map(socialReasonService.save(sr), SocialReasonDTO.class);
	}
	
	@PutMapping("/social-reasons")
	@ResponseStatus(value=HttpStatus.OK)
	public SocialReasonDTO  updateSocialReason(@RequestBody SocialReasonDTO sro) {
		SocialReason sr = modelMapper.map(sro, SocialReason.class);		
		return modelMapper.map(socialReasonService.save(sr), SocialReasonDTO.class);
	}
	
	@DeleteMapping(value = "/social-reasons/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		socialReasonService.delete(id);
	}

}
