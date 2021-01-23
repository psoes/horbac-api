package com.uds.horbac.core.dao.organizations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.entities.organizations.OrganizationType;

@Repository
public interface OrganizationTypeRepository extends JpaRepository<OrganizationType, Long> {

}
