package com.uds.horbac.core.entities.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OPERATIONAL")
public class OperationalUnit extends OrgUnit{
	public OperationalUnit() {
		super();
	}
}

