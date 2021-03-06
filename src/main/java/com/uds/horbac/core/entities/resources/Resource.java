package com.uds.horbac.core.entities.resources;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * 
 * @author fidele
 * a ressource here represents a resource server in oauth 2.0 meaning
 */
@Data
@Entity
public class Resource
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	/**
	 * The uri of the resource
	 */
	private String uri;
	/**
	 * The list of require scopes for the resource
	 */
	@OneToMany
	@JoinColumn(name = "resource_id") 
	private List<Scope> scopes;  
    
}

