package com.uds.horbac.core.dao.emp_educationInfo;

import com.uds.horbac.core.entities.emp_educationInfo.School;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Api(tags = "School Entity")
@RepositoryRestResource(path = "schools", exported = true)
public interface SchoolRepository extends JpaRepository<School, Long>{

}
