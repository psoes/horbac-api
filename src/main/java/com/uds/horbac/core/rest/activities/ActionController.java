package com.uds.horbac.core.rest.activities;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.activities.ActionDTO;
import com.uds.horbac.core.entities.activities.Action;
import com.uds.horbac.core.service.activities.ActionService;

@RestController
public class ActionController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private ActionService actionService;
	
	@GetMapping("/actions")
	@ResponseStatus(value=HttpStatus.OK)
	public List<ActionDTO> getActions() {
		List<Action> actions = actionService.getAll();
		List<ActionDTO> dtos = actions.stream()
				.map(ac -> modelMapper.map(ac, ActionDTO.class))
				.collect(Collectors.toList());
		return dtos;
	}
	
	@GetMapping("/actions/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public ActionDTO getActionById(@PathVariable Long id){
		Action action = actionService.getAction(id);
		return modelMapper.map(action, ActionDTO.class);
	}
	
	@PostMapping("/actions")
	@ResponseStatus(value=HttpStatus.CREATED)
	public ActionDTO createAction(@RequestBody ActionDTO actionDTO){
		Action action = modelMapper.map(actionDTO, Action.class);
		Action respaction = actionService.save(action);		
		return modelMapper.map(respaction, ActionDTO.class);
	}
	
	@PutMapping("/actions")
	@ResponseStatus(value=HttpStatus.OK)
	public ActionDTO updateAction(@RequestBody ActionDTO actionDTO) {
		Action action = modelMapper.map(actionDTO, Action.class);
		Action respaction = actionService.save(action);		
		return modelMapper.map(respaction, ActionDTO.class);
	}
	
	@DeleteMapping(value = "/actions/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		actionService.delete(id);
	}	

}
