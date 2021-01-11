package com.uds.horbac.core.dao.organizations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uds.horbac.core.entities.organizations.OrganizationType;

import io.swagger.annotations.Api;

@Api(tags = "Organization Type Entity")
@RepositoryRestResource(path = "org-types", exported = true)
public interface OrganizationTypeRepository extends JpaRepository<OrganizationType, Long> {

}
