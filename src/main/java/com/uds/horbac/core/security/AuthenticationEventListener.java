package com.uds.horbac.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.utils.PropertyUtils;

@Component
public class AuthenticationEventListener {
	
	@Autowired
	private LoginAttemptService atpService;

    @EventListener
    public void authenticationFailed(AuthenticationFailureBadCredentialsEvent event) {
    	
        String username = (String) event.getAuthentication().getPrincipal();
        atpService.updatePasswordRetryAttempts(username, PropertyUtils.getLoginAttendLimits());
    }
    
    @EventListener
    public void authenticationSucceed(AuthenticationSuccessEvent event) {
  
        User user = (User) event.getAuthentication().getPrincipal();
        atpService.resetPasswordRetryAttempts(user.getUsername());
    }
}
