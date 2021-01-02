package com.uds.horbac.core.service.activities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.activities.ActivityRepository;
import com.uds.horbac.core.entities.activities.Activity;

@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	ActivityRepository ActivityRepository;

	@Override
	public Activity save(Activity activity) {
		return ActivityRepository.save(activity);
	}

	@Override
	public void delete(Long id) {
		ActivityRepository.deleteById(id);
		
	}

	@Override
	public List<Activity> getAll() {
		return ActivityRepository.findAll();
	}

	@Override
	public Activity getActivity(Long id) {
		return ActivityRepository.getOne(id);
	}

}
