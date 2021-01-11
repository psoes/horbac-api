package com.uds.horbac.core.dao.organizations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uds.horbac.core.entities.organizations.SocialReason;

import io.swagger.annotations.Api;

@Api(tags = "Social Reason Entity")
@RepositoryRestResource(path = "social-reasons", exported = true)
public interface SocialReasonRepository extends JpaRepository<SocialReason, Long>{

}
