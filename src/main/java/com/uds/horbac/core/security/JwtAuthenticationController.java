package com.uds.horbac.core.security;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.service.users.UserService;
import com.uds.horbac.core.utils.PropertyUtils;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Organization Type Entity")
@RequestMapping(produces="application/json")
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private LoginAttemptService atpService;
	
	@Autowired
	private UserService userService;

	protected final Log logger = LogFactory.getLog(JwtAuthenticationController.class);
	
	@PostMapping("/authenticate")
	@ResponseStatus(value=HttpStatus.OK)
	public ResponseEntity<Jwt> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws UsernameNotFoundException{

		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes())
                .getRequest(); 
		
		//System.out.println("VRAI VRAI VRAI "+encoder.matches(authenticationRequest.getPassword(), userDetails1.getPassword()));
		JWTStatus status = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());	
		if(status == JWTStatus.AUTHENTICATED) {
			final User	userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
			
			if(userDetails != null) {
				String ip = getClientIp(request);
				String agent = getUserAgent(request);
				
				final String token = jwtTokenUtil.generateToken(userDetails, ip, agent);
				Date tokenExp = jwtTokenUtil.getExpirationDateFromToken(token);
				String uniqueID = UUID.randomUUID().toString();
				return ResponseEntity.ok(new Jwt(uniqueID, JWTStatus.AUTHENTICATED, ip, agent, token,
						tokenExp, null, userDetails, null));
			}
			else {
				return ResponseEntity.ok(new Jwt(null, JWTStatus.BAD_CREDENTIALS, "", "", 
						null, null, null, null, null));
			}
		}
		else {
			//empty JWT response just with status
			return ResponseEntity.ok(new Jwt(null, status, "", "", 
					null, null, null, null, null));
		}
	}
	
	private JWTStatus authenticate(String username, String password) throws AuthenticationException {

		try {
			if(atpService.getByUsername(username).getAttempts() == PropertyUtils.getLoginAttendLimits()) return JWTStatus.ATTEMPT_LIMIT_REACHED;
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			return JWTStatus.AUTHENTICATED;
		} catch (DisabledException e) {
			logger.warn(e.getMessage());
			e.printStackTrace();
			return JWTStatus.USER_DISABLED;
		} catch (BadCredentialsException e) {
			logger.warn(e.getMessage());
			//e.printStackTrace();
			return JWTStatus.BAD_CREDENTIALS;
		}catch(LockedException e) {
			logger.warn(e.getMessage());
			//e.printStackTrace();
			return JWTStatus.ACCOUNT_LOCKED;
		}catch(AccountExpiredException e) {
			logger.warn(e.getMessage());
			//e.printStackTrace();
			return JWTStatus.ACCOUNT_EXPIRED;			
		}
		catch(Exception e) {
			//e.printStackTrace();
			logger.warn(e.getMessage());
			return JWTStatus.ACCOUNT_NOT_FOUND;
		}
	}
	
	private static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
	}
	
	public static String getUserAgent(HttpServletRequest request) {
	    String ua = "";
	    if (request != null) {
	        ua = request.getHeader("User-Agent");
	    }
	    return ua;
	}
	
	@PostMapping(value = "/logout/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id, @RequestBody Jwt jwt){
		jwtService.save(jwt);
	}
}
