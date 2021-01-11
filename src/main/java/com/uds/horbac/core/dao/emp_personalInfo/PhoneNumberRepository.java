package com.uds.horbac.core.dao.emp_personalInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uds.horbac.core.entities.emp_personalInfo.PhoneNumber;

import io.swagger.annotations.Api;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Api(tags = "PhoneNumber Entity")
@RepositoryRestResource(path = "phoneNumbers", exported = true)
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, String>, JpaSpecificationExecutor<PhoneNumber>{

}