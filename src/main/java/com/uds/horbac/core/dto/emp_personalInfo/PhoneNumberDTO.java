
package com.uds.horbac.core.dto.emp_personalInfo;
import com.uds.horbac.core.entities.emp_personalInfo.ContactType;

import lombok.Data;

@Data
public class PhoneNumberDTO

{
    private String phone;
   
	private PhoneOperatorDTO operator;
	
    private ContactType type;
}

