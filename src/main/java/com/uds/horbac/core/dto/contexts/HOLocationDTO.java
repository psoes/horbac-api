package com.uds.horbac.core.dto.contexts;

import lombok.Data;

@Data
public class HOLocationDTO {
	private Long id;
    private String name;
    private double longitude;
    private double latitude;
}
