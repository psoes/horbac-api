package com.uds.horbac.core.dto.employees;

import com.uds.horbac.core.dto.emp_personalInfo.PersonDTO;
import com.uds.horbac.core.dto.emp_personalInfo.SpecialIdentityDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class EmployeeCrudDTO extends PersonDTO{
	private SpecialIdentityDTO specialID;
}
