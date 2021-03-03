package com.uds.horbac.core.dao.organizations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uds.horbac.core.entities.organizations.OrganizationType;

import io.swagger.annotations.Api;

@Api(tags = "Organization Type Entity")
@CrossOrigin(origins = "*",
	methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH },
maxAge = 3600)
@RepositoryRestResource(path = "org-types", exported = true)
public interface OrganizationTypeRepository extends JpaRepository<OrganizationType, Long> {

}
