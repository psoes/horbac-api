package com.uds.horbac.core.units;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class PlaceUnder

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
	
	@ManyToOne
    private AministrativeUnit superior;
    
	@ManyToOne
    private OperationalUnit subordinate ;
}

