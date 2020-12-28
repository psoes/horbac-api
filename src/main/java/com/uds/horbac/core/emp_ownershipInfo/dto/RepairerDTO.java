package com.uds.horbac.core.emp_ownershipInfo.dto;

import com.uds.horbac.core.emp_ownershipInfo.entities.RepairerSpeciality;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairerDTO {
	
	private RepairerSpeciality speciality;
}
