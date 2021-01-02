package com.uds.horbac.core.entities.emp_personalInfo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Handicap

{
    /** Attributes */
    /**
     * 
     */
    public String description;
    /**
     * 
     */
    @Id
    private Long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    @ManyToOne
    private HandicapType type;
}

