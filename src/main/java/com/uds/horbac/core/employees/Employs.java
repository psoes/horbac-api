package com.uds.horbac.core.employees;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.unities.OperationalUnit;

import lombok.Data;

@Data
@Entity
public class Employs

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /** Associations */
	@ManyToOne
    private WorkEmployee employee;
    
	@ManyToOne
    private OperationalUnit operationalUnit;
}

