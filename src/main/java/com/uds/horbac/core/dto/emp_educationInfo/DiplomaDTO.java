package com.uds.horbac.core.dto.emp_educationInfo;
import java.util.Date;

import lombok.Data;

@Data
public class DiplomaDTO

{
 
    private Long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private String mention;
    /**
     * 
     */
    private Date startDate;
    /**
     * 
     */
    private Date endDate;
}

