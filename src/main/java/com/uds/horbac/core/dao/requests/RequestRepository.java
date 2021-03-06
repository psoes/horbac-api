package com.uds.horbac.core.dao.requests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uds.horbac.core.entities.requests.Request;

import io.swagger.annotations.Api;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Api(tags = "Request Entity")
@RepositoryRestResource(path = "requests", exported = true)
public interface RequestRepository extends JpaRepository<Request, Long>, JpaSpecificationExecutor<Request>{

}
