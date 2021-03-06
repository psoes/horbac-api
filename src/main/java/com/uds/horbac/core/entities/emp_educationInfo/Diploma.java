package com.uds.horbac.core.entities.emp_educationInfo;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Diploma

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
    private String mention;
    /**
     * 
     */
    private Date startDate;
    /**
     * 
     */
    private Date endDate;
}

