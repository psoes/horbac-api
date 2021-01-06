
package com.uds.horbac.core.dto.emp_educationInfo;
import java.util.Date;

import lombok.Data;

@Data
public class ScholarshipDTO

{
 
    private Long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private Date startDate;
    /**
     * 
     */
    private Date endDate;
    /**
     * 
     */
    private Double pricePerMonth;
}

