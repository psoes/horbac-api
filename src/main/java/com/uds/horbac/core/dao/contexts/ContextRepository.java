package com.uds.horbac.core.dao.contexts;

import com.uds.horbac.core.entities.contexts.Context;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextRepository extends JpaRepository<Context, Long>{

}
