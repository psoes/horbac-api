package com.uds.horbac.core.emp_educationInfo.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.entities.Location;

import lombok.Data;

@Data
@Entity
public class Award

{
    /** Attributes */
    /**
     * 
     */
	@Id
    public Long id;
    /**
     * 
     */
    public String description;
    /**
     * 
     */
    public Date date;
    /**
     * 
     */
    @OneToOne
    public Location location;
}

