package com.uds.horbac.core.entities.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMINISTRATIVE")
public class AdministrativeUnit extends OrgUnit
{
	public AdministrativeUnit() {
		super();
	}
}

