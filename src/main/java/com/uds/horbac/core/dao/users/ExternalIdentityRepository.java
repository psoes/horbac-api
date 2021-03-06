package com.uds.horbac.core.dao.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.entities.users.ExternalIdentity;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Repository
public interface ExternalIdentityRepository extends JpaRepository<ExternalIdentity, Long>, JpaSpecificationExecutor<ExternalIdentity> {

}
