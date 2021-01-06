package com.uds.horbac.core.dto.units;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OperationalUnitDTO extends OrgUnitDTO{
	public OperationalUnitDTO() {
		super();
	}
}

