package com.uds.horbac.core.entities.emp_educationInfo;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
    public HOLocation location;
}

