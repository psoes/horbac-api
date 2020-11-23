package com.uds.horbac.core.employees;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
public class Approver extends WorkEmployee
{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
}

