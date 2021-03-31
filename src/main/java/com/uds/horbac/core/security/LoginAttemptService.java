package com.uds.horbac.core.security;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAttemptService {
	@Autowired
	private LoginAttemptRepository logaRepository;

	public List<LoginAttempt> getAll() {
		List<LoginAttempt> logas = new ArrayList<LoginAttempt>();
		logaRepository.findAll().forEach(logas::add);		
		return logas;
	}

	public LoginAttempt save(LoginAttempt loga) {
		return logaRepository.save(loga);
	}

	public LoginAttempt getByUsername(String username) {
		LoginAttempt loga = new LoginAttempt();
		try {
			loga = logaRepository.findByUsername(username).get();
		}catch(NoSuchElementException e) {}
		
		return loga;
	}

	public void updatePasswordRetryAttempts(String username, int loginAttendLimits) {
		LoginAttempt at = getByUsername(username);
		if(at != null && at.getAttempts() < loginAttendLimits) { 
			int atp = at.getAttempts() + 1;
			at.setAttempts(atp);
			logaRepository.save(at);
		}
		else if(at == null){
			at = new LoginAttempt();
			at.setAttempts(1);
			at.setUsername(username);
			logaRepository.save(at);
		}
		
	}

	public void resetPasswordRetryAttempts(String username) {
		LoginAttempt at = getByUsername(username);
		if(at != null) {
			at = new LoginAttempt();
			at.setAttempts(0);
			at.setUsername(username);
			logaRepository.save(at);
		}
	}
}
