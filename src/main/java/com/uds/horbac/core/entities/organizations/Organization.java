package com.uds.horbac.core.entities.organizations;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.uds.horbac.core.entities.contexts.HOLocation;
import com.uds.horbac.core.entities.emp_personalInfo.Address;
import com.uds.horbac.core.entities.emp_personalInfo.Person;

import lombok.Data;

@Data
@Entity
public class Organization implements Serializable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@NotNull(message="The organization name should'nt be blank")
    private String name;
    
	@Column(columnDefinition = "TEXT")
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
 
    private String url;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    private HOLocation location;
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private SocialReason socialReason;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    private Address address;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Person owner;
    
    private String logo;

    private boolean pendingApproval;
}

