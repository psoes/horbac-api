package com.uds.horbac.core.dao.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.entities.employees.Emitter;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Repository
public interface EmitterRepository extends JpaRepository<Emitter, Long>, JpaSpecificationExecutor<Emitter> {

}
