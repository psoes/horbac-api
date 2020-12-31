package com.uds.horbac.core.emp_ownershipInfo.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.Location;

import lombok.Data;

@Data
@Entity

public class BiensImmobiliers

{
    /** Attributes */
    /**
     * 
     */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;
    /**
     * 
     */
    public String name;
    /**
     * 
     */
    @OneToOne
    public Location location;
    /**
     * 
     */
    public Date dateObtention;
}

