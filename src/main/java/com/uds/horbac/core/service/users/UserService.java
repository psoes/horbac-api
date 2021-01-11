package com.uds.horbac.core.service.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uds.horbac.core.dao.users.UserRepository;
import com.uds.horbac.core.entities.users.User;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.findAll(); 
	}

	public User getUser(Long id) {
		return userRepository.getOne(id);
	}

	public Object save(User eid) {
		return userRepository.save(eid);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}