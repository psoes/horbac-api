package com.uds.horbac.core.dto.users;

import com.uds.horbac.core.dto.employees.EmployeeDTO;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	private String username;
	

	private String hashed_password;
	
	/**
	 * the user's picture
	 */
	private String picture;
	
	private Boolean active;

	private EmployeeDTO employee;
	
	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private boolean enabled;

}
