package com.uds.horbac.core.dao.emp_educationInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uds.horbac.core.entities.emp_educationInfo.Scholarship;

import io.swagger.annotations.Api;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Api(tags = "Scolarship Entity")
@RepositoryRestResource(path = "scolarships", exported = true)
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long>, JpaSpecificationExecutor<Scholarship>{

}
