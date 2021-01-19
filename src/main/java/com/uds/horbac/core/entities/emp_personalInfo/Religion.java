
package com.uds.horbac.core.entities.emp_personalInfo;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;

import lombok.Data;

@Data
@Entity
public class Religion

{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    
    private ReligionType type;

    private Date startDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    private HOLocation location;

}

