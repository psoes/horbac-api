package com.uds.horbac.core.dao.emp_healthInfo;

import com.uds.horbac.core.entities.emp_healthInfo.Hospital;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Generated by Spring Data Generator on 31/12/2020
 */
@Api(tags = "Hospital Entity")
@RepositoryRestResource(path = "hospitals", exported = true)
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
