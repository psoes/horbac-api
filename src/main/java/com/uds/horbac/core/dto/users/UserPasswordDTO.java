package com.uds.horbac.core.dto.users;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserPasswordDTO {
	@Length(max=50)
	private String oldPassword;
	
	@NotEmpty(message="The new password is required")
	@Length(max=50)
	private String newPassword;
	
}
