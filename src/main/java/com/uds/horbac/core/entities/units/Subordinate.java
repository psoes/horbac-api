package com.uds.horbac.core.entities.units;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    /** Associations */
	
	@ManyToOne
    private AdministrativeUnit subordinate;
	
	@ManyToOne
    private AdministrativeUnit superior;
}

