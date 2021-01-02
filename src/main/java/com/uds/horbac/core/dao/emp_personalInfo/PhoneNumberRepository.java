package com.uds.horbac.core.dao.emp_personalInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.entities.emp_personalInfo.PhoneNumber;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, String>, JpaSpecificationExecutor<PhoneNumber>{

}
