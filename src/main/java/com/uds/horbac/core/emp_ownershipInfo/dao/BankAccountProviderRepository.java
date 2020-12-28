package com.uds.horbac.core.emp_ownershipInfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.emp_ownershipInfo.entities.BankAccountProvider;

@Repository
public interface BankAccountProviderRepository extends JpaRepository<BankAccountProvider , Long> {

}
