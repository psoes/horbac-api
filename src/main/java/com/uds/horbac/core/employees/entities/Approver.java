package com.uds.horbac.core.employees.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
public class Approver extends Employee
{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
}

