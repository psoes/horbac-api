package com.uds.horbac.core.emp_personalInfo.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.Location;

import lombok.Data;

@Data
@Entity
public class City

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    @OneToOne
    private Location location;
    /**
     * 
     */
    @ManyToOne
    private Country country;
}

