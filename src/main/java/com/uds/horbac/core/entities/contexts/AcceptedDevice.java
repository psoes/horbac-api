package com.uds.horbac.core.entities.contexts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AcceptedDevice {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
    private DeviceType type;
    
    private String browser_name;
    
    private String browser_version;
    
    private String platform_name;
    
    private String platform_version;    
    
}
