package com.uds.horbac.core.dto.employees;

import com.uds.horbac.core.dto.organizations.OrganizationDTO;
import com.uds.horbac.core.dto.units.OperationalUnitDTO;

import lombok.Data;

@Data
public class EmploysDTO

{
    private Long id;
  
    private EmployeeDTO employee;

    private OperationalUnitDTO operationalUnit;

	private OrganizationDTO organization;
}

