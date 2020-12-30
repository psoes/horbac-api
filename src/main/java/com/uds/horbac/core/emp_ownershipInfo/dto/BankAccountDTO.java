package com.uds.horbac.core.emp_ownershipInfo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDTO {

	@ApiModelProperty(name="The Bank code")
	private String code;
	private BankAccountProviderDTO provider;
}
