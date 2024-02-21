package com.uds.horbac.core.security;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import lombok.Data;

import java.io.Serializable;

@Getter
@Setter
//@RedisHash("LoginAttempt")
@Entity
@Table(name="login_attempt")
@NoArgsConstructor(force = true)
public class LoginAttempt implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String username;
	private int attempts;
}
