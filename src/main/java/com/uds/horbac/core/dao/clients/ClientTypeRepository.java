package com.uds.horbac.core.dao.clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uds.horbac.core.entities.clients.ClientType;

import io.swagger.annotations.Api;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Api(tags = "Client Type Entity")
@RepositoryRestResource(path = "types", exported = true)
public interface ClientTypeRepository extends JpaRepository<ClientType, Long>{

}