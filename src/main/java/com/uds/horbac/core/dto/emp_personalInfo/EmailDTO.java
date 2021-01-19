package com.uds.horbac.core.dto.emp_personalInfo;
import com.uds.horbac.core.entities.emp_personalInfo.ContactType;

import lombok.Data;

@Data
public class EmailDTO

{
    private String email;
   
    private ContactType type;
}

