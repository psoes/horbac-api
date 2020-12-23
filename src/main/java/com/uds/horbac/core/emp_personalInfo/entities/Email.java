package com.uds.horbac.core.emp_personalInfo.entities;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Email

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private String email;
    /**
     * 
     */    
    private ContactType type;
}

