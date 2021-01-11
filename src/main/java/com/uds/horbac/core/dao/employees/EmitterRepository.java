package com.uds.horbac.core.dao.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uds.horbac.core.entities.employees.Emitter;

import io.swagger.annotations.Api;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Api(tags = "Emitter Entity")
@RepositoryRestResource(path = "emitters", exported = true)
public interface EmitterRepository extends JpaRepository<Emitter, Long>, JpaSpecificationExecutor<Emitter> {

}
