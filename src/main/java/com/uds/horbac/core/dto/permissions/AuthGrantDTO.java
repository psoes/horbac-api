package com.uds.horbac.core.dto.permissions;

import java.util.List;

import com.uds.horbac.core.dto.clients.ClientDTO;
import com.uds.horbac.core.dto.resources.ScopeDTO;
import com.uds.horbac.core.dto.users.UserDTO;

import lombok.Data;

@Data
public class AuthGrantDTO {

	
	private Long id;
	

	private UserDTO user;
	

	private ClientDTO client;
	
	private List<ScopeDTO> grantedScopes;
}
