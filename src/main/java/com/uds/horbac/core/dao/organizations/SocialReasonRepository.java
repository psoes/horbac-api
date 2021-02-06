package com.uds.horbac.core.dao.organizations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uds.horbac.core.entities.organizations.SocialReason;

import io.swagger.annotations.Api;

@Api(tags = "Social Reason Entity")
@CrossOrigin(origins = "http://localhost:4200",
	methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH },
maxAge = 3600)
@RepositoryRestResource(path = "social-reasons", exported = true)
public interface SocialReasonRepository extends JpaRepository<SocialReason, Long>{

}
