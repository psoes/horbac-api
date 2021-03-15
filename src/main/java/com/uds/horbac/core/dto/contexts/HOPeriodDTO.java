package com.uds.horbac.core.dto.contexts;

import java.util.Date;

import lombok.Data;

@Data
public class HOPeriodDTO {
private Long id;
	
    private String name;
    
    private Date dateFrom;
    
    private Date dateTo;
}
