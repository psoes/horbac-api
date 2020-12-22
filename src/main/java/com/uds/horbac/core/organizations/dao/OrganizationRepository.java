package com.uds.horbac.core.organizations.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.organizations.entities.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
