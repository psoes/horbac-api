package com.uds.horbac.core.users.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.employees.entities.Employee;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=50, unique=true)
	private String username;
	
	@Column(length=150)
	private String hashed_password;
	
	/**
	 * the user's picture
	 */
	private String picture;
	
	private Boolean active;
	
	@OneToOne
	private Employee employee;
	
	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private boolean enabled;

}
