package com.uds.horbac.core.organizations.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Organization {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
	@NotNull
    private String name;
    
    private String description;
    
    /**
	 * Date of creation
	 */
	private Date inceptionDate;
	
	/**
	 * End of service dates
	 */
	private Date cessationDate;
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private OrganizationType type;
    
    private String website;
    
    private String localization;
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private SocialReason socialReason;
}

