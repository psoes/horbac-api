package com.uds.horbac.core.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.uds.horbac.core.entities.permissions.CanSuggest;
import com.uds.horbac.core.entities.users.User;

import lombok.Data;

@Data
@RedisHash("Jwt")
public class Jwt implements Serializable{
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	//the status of the response
	private JWTStatus jwtStatus;
	
	//the ip identifier
	private String ip;
	
	//The user agent
	private String agent;
	
	// the jwt token 
	private final String jwttoken;
	
	//the token expiration date
	private final Date expirationTime;
	
	//the token issue date
	private final Date issueTime;
	
	// the user details information
	private User user;
	
	//the user privileges
	private Collection<CanSuggest> privileges;

	public Jwt(String id, JWTStatus jwtStatus, String ip, String agent, String jwttoken, Date expirationTime,
			Date issueTime, User user, Collection<CanSuggest> privileges) {
		super();
		this.id = id;
		this.jwtStatus = jwtStatus;
		this.ip = ip;
		this.agent = agent;
		this.jwttoken = jwttoken;
		this.expirationTime = expirationTime;
		this.issueTime = issueTime;
		this.user = user;
		this.privileges = privileges;
	}
	
	
	
}