package com.uds.horbac.core.emp_passionInfo.entities;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Food

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
    public String name;
    /**
     * 
     */
    public String description;
    /**
     * 
     */
    public Double price;
}
