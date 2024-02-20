package com.uds.horbac.core.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import com.uds.horbac.core.entities.permissions.CanSuggest;
import com.uds.horbac.core.entities.users.User;

import lombok.Data;

@Data
//@RedisHash("Jwt")
@Entity
@NoArgsConstructor(force = true)
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
	@ManyToOne
	private User user;
	
	//the user privileges
	@Transient
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