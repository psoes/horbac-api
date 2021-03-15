package com.uds.horbac.core.dto.contexts;

import com.uds.horbac.core.entities.contexts.DeviceType;

import lombok.Data;


@Data
public class AcceptedDeviceDTO {
	
    private Long id;
	
    private DeviceType type;
    
    private String browser_name;
    
    private String browser_version;
    
    private String platform_name;
    
    private String platform_version;    
    
}
