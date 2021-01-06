package com.uds.horbac.core.dto.emp_personalInfo;
import lombok.Data;

@Data
public class HandicapDTO

{
    /** Attributes */
    /**
     * 
     */
    public String description;

    private Long id;
    /**
     * 
     */
    private String name;

    private HandicapTypeDTO type;
}

