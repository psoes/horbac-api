package com.uds.horbac.core.activities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.activities.dao.ActionRepository;
import com.uds.horbac.core.activities.entities.Action;

@Service
public class ActionServiceImpl implements ActionService {
	
	@Autowired
	ActionRepository actionRepository;
	
	@Override
	public Action save(Action action) {
		return actionRepository.save(action);
	}

	@Override
	public void delete(Long id) {
		actionRepository.deleteById(id);		
	}

	@Override
	public List<Action> getAll() {
		return actionRepository.findAll();
	}

	@Override
	public Action getAction(Long id) {
		return actionRepository.getOne(id);
	}

}
