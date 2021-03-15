
package com.uds.horbac.core.dto.emp_justiceInfo;
import java.util.Date;

import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class LitigationJusticeDTO

{
    private Long id;
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
 
    private HOLocationDTO location;
}

