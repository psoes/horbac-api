
package com.uds.horbac.core.dto.emp_passionInfo;
import java.util.Date;
import java.util.List;

import com.uds.horbac.core.dto.contexts.LocationDTO;

import lombok.Data;

@Data
public class VisitDTO

{
   
    private long id;
    /**
     * 
     */
    private Date startDate;
    /**
     * 
     */
    private Date endDate;

    private List<LocationDTO> places;
}

