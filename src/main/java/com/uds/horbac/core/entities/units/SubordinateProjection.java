package com.uds.horbac.core.entities.units;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.uds.horbac.core.entities.organizations.Organization;

@Projection(name ="custom", types = {Subordinate.class})
public interface SubordinateProjection {
	
	Long getId();
	
	Organization getOrganization();
	
	@Value("#{target.subordinate}")
	AdministrativeUnit getSubordinate();
	
	@Value("#{target.superior}")
	AdministrativeUnit getSuperior();
	
	
	
}
