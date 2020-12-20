package com.uds.horbac.core.units;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Subordinate

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /** Associations */
	
	@ManyToOne
    private AdministrativeUnit subordinate;
	
	@ManyToOne
    private AdministrativeUnit superior;
}

