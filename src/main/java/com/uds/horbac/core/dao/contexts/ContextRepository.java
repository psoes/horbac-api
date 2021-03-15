package com.uds.horbac.core.dao.contexts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.entities.contexts.Context;

@Repository
public interface ContextRepository extends JpaRepository<Context, Long>, JpaSpecificationExecutor<Context>{

}
