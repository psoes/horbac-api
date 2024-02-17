package com.uds.horbac.core.entities.units;

import javax.persistence.*;

import com.uds.horbac.core.entities.organizations.Organization;
import org.hibernate.validator.constraints.URL;

import com.uds.horbac.core.entities.contexts.HOLocation;
import com.uds.horbac.core.entities.emp_personalInfo.Address;

import lombok.Data;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data
public class OrgUnit{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    
	@OneToOne(cascade = CascadeType.PERSIST)
    private HOLocation location;
	
	@URL
	private String url;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
    @OneToOne(cascade = CascadeType.PERSIST)
	private Address address;
    
    private String logo;

	@ManyToOne
	private Organization organization;
    
	public OrgUnit () {}

	public OrgUnit(Long id, String name, HOLocation location, String url, String description, Address address,
			String logo) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.url = url;
		this.description = description;
		this.address = address;
		this.logo = logo;
	}



	public Long getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HOLocation getLocation() {
		return location;
	}

	public void setLocation(HOLocation location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "OrgUnit [id=" + id + ", name=" + name + ", location=" + location + ", url=" + url + ", description="
				+ description + ", address=" + address + "]";
	}


}
