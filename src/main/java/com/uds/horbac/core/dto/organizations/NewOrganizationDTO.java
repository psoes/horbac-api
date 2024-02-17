package com.uds.horbac.core.dto.organizations;

import com.uds.horbac.core.dto.emp_personalInfo.PersonDTO;
import com.uds.horbac.core.dto.units.AdministrativeUnitDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewOrganizationDTO {
    private OrganizationDTO organization;
    private AdministrativeUnitDTO root;
    private PersonDTO owner;
}
