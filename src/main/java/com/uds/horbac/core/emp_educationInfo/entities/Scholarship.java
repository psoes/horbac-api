
package com.uds.horbac.core.emp_educationInfo.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Scholarship

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
    private Date startDate;
    /**
     * 
     */
    private Date endDate;
    /**
     * 
     */
    private Double pricePerMonth;
}

