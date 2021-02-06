package com.uds.horbac.core.entities.organizations;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.uds.horbac.core.entities.contexts.HOLocation;
import com.uds.horbac.core.entities.emp_personalInfo.Address;
import com.uds.horbac.core.entities.emp_personalInfo.Person;

import lombok.Data;

@Data
@Entity
public class Organization {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@NotNull(message="The organization name should'nt be blank")
    private String name;
    
	@Lob
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
    
    @Lob
    private String url;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    private HOLocation location;
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private SocialReason socialReason;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    private Address address;
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private Person owner;
    
    private String logo;
}

