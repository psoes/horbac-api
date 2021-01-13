
package com.uds.horbac.core.entities.emp_personalInfo;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PhoneNumber

{
	@Id	
    private String phone;
	
	private String code;
    /**
     * 
     */
	private String operator;
	
    private ContactType type;
}

