package com.uds.horbac.core.dto.units;

import com.uds.horbac.core.dto.contexts.LocationDTO;

import lombok.Data;

@Data
public class OrgUnitDTO {
	
    private Long id;

    private String name;

    private LocationDTO location;

	private String url;

}
