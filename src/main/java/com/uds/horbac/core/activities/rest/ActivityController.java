package com.uds.horbac.core.activities.rest;

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

import com.uds.horbac.core.activities.dto.ActivityDTO;
import com.uds.horbac.core.activities.entities.Activity;
import com.uds.horbac.core.activities.service.ActivityService;

@RestController
@RequestMapping(produces="application/json")
public class ActivityController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private ActivityService activityService;
	
	
	@GetMapping("/activities")
	@ResponseStatus(value=HttpStatus.OK)
	public List<ActivityDTO> getActivities() {
		List<Activity> cycles = activityService.getAll();
		List<ActivityDTO> cycleDtos = cycles.stream()
				.map(cycle -> modelMapper.map(cycle, ActivityDTO.class))
				.collect(Collectors.toList());
		return cycleDtos;
	}
	
	@GetMapping("/activities/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public ActivityDTO getActivityById(@PathVariable Long id){
		Activity activity = activityService.getActivity(id);
		return modelMapper.map(activity, ActivityDTO.class);
	}
	
	@PostMapping("/activities")
	@ResponseStatus(value=HttpStatus.CREATED)
	public ActivityDTO createActivity(@RequestBody ActivityDTO activityDTO){
		Activity activity = modelMapper.map(activityDTO, Activity.class);
		Activity respactivity = activityService.save(activity);
		
		return modelMapper.map(respactivity, ActivityDTO.class);
	}
	
	@PutMapping("/activities")
	@ResponseStatus(value=HttpStatus.OK)
	public ActivityDTO updateActivity(@RequestBody ActivityDTO activityDTO) {
		Activity activity = modelMapper.map(activityDTO, Activity.class);
		Activity respactivity = activityService.save(activity);
		
		return modelMapper.map(respactivity, ActivityDTO.class);
	}
	
	@DeleteMapping(value = "/activities/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		activityService.delete(id);
	}

}
