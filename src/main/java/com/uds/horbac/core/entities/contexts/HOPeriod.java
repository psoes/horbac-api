package com.uds.horbac.core.entities.contexts;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class HOPeriod {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
    private String name;
    
    private Date dateFrom;
    
    private Date dateTo;
}
