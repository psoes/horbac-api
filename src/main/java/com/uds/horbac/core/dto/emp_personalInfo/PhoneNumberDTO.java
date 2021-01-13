
package com.uds.horbac.core.dto.emp_personalInfo;
import com.uds.horbac.core.entities.emp_personalInfo.ContactType;

import lombok.Data;

@Data
public class PhoneNumberDTO

{
    private String phone;
   
	private String operator;
	
	private String code;
	
    private ContactType type;
}

