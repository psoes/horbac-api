package com.uds.horbac.core.dto.units;

import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class OrgUnitDTO {
	
    private Long id;

    private String name;

    private HOLocationDTO location;

	private String url;

}
