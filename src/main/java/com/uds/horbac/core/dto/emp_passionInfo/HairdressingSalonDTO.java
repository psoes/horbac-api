package com.uds.horbac.core.dto.emp_passionInfo;
import java.util.List;

import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class HairdressingSalonDTO

{
    private Long id;
    /**
     * 
     */
    private String name;

    private HOLocationDTO location;

    private List<HairStyleDTO> favoriteStyles;
}

