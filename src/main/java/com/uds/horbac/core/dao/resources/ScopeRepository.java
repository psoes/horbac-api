package com.uds.horbac.core.dao.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uds.horbac.core.entities.resources.Scope;

import io.swagger.annotations.Api;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Api(tags = "Scope Entity")
@RepositoryRestResource(path = "scope", exported = true)
public interface ScopeRepository extends JpaRepository<Scope, Long>, JpaSpecificationExecutor<Scope> {
}
