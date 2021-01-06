package com.uds.horbac.core.dao.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.entities.resources.Vue;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Repository
public interface VueRepository extends JpaRepository<Vue, Long>, JpaSpecificationExecutor<Vue> {

}
