package com.uds.horbac.core.employees;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.units.OperationalUnit;

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
	@OneToOne
    private WorkEmployee employee;
    
	@OneToOne
    private OperationalUnit operationalUnit;
}

