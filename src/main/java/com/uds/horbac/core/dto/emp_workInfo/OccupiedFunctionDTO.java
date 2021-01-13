
package com.uds.horbac.core.dto.emp_workInfo;
import java.util.Date;

import com.uds.horbac.core.dto.employees.EmployeeCrudDTO;

import lombok.Data;

@Data
public class OccupiedFunctionDTO

{
   
    private Long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private String description;
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
    private Double salaryPerMonth;
  
    private CompanyDTO company;
    
    private EmployeeCrudDTO employee;
}

