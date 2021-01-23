
package com.uds.horbac.core.entities.emp_personalInfo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PhoneNumber

{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String phone;
	
	private String code;

	private String operator;
	
    private ContactType type;
}

