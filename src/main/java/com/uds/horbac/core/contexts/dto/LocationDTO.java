package com.uds.horbac.core.contexts.dto;

import lombok.Data;

@Data
public class LocationDTO {
	private Long id;
    private String name;
    private double longitude;
    private double latitude;
}
