package com.uds.horbac.core.dao.emp_passionInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uds.horbac.core.entities.emp_passionInfo.HairStyle;

import io.swagger.annotations.Api;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Api(tags = "HairStyle Entity")
@RepositoryRestResource(path = "hairStyles", exported = true)
public interface HairStyleRepository extends JpaRepository<HairStyle, Long>, JpaSpecificationExecutor<HairStyle>{

}