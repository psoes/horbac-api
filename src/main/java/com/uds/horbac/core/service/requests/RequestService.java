package com.uds.horbac.core.service.requests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uds.horbac.core.dao.requests.RequestRepository;
import com.uds.horbac.core.entities.requests.Request;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class RequestService {
	
	@Autowired
	private RequestRepository requestRepository;

	public void delete(Long id) {
		requestRepository.deleteById(id);
	}

	public Request save(Request req) {
		return requestRepository.save(req);
	}

	public Request getRequest(Long id) {
		return requestRepository.findById(id).orElse(null);
	}

	public List<Request> getAll() {
		return requestRepository.findAll();
	}

}