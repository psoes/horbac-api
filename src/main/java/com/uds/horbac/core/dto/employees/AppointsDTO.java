package com.uds.horbac.core.dto.employees;

import com.uds.horbac.core.dto.organizations.OrganizationDTO;
import com.uds.horbac.core.dto.units.AdministrativeUnitDTO;

import lombok.Data;

@Data
public class AppointsDTO

{
   
    private Long id;
   
    private EmployeeDTO employee;
	

	private AdministrativeUnitDTO adminUnit;

	private OrganizationDTO organization;
}

