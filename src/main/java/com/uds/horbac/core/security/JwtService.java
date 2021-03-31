package com.uds.horbac.core.security;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
	

	@Autowired
	private JwtRepository jwtRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public List<Jwt> getAll() {
		List<Jwt> jwts = new ArrayList<Jwt>();
		try {
			jwtRepository.findAll().forEach(jwts::add);
		}catch(NoSuchElementException e) {			
		}	
		
		return jwts;
	}

	public void delete(Jwt jwt) {
		jwtRepository.deleteById(jwt.getId());		
	}

	public Jwt save(Jwt jwt) {
		return jwtRepository.save(jwt);
	}

	public Jwt get(String id) {
		try {
			return jwtRepository.findById(id).get();
		}catch(NoSuchElementException e) {	
			return null;
		}
	}
	
	public Jwt update(Jwt jwt) {
		Jwt n_ew = jwtRepository.findById(jwt.getId()).get();
		if(n_ew != null) { 
			n_ew =  jwtRepository.save(jwt);
		}
		return n_ew;		
	}
	
	/**
	 * Clear all expired tokens whithout considering, token can be refresh
	 */
	@Scheduled(cron = "0 0/30 * * * ?")              // execure after every 30 min 
	public void clearCacheSchedule(){
		try {
			for(Jwt jwt : jwtRepository.findAll()) {
				if(jwtTokenUtil.isTokenExpired(jwt.getJwttoken())) jwtRepository.delete(jwt);
			}
		}catch(NoSuchElementException e) {			
		}
	}



}
