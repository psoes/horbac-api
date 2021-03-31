package com.uds.horbac.core.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


import lombok.Data;

@Data
//@RedisHash("LoginAttempt")
@Entity
public class LoginAttempt {	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String username;
	private int attempts;
}
