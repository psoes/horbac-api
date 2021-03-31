package com.uds.horbac.core.dto.users;

import com.uds.horbac.core.dto.employees.EmployeeDTO;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	private String username;	

	private String password;
	
	private String picture;
	
	private boolean active;

	private EmployeeDTO employee;
	
	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private boolean enabled;

}
