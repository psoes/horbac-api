package com.uds.horbac.core.dao.contexts;

import com.uds.horbac.core.entities.contexts.HOPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*",
methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH },
maxAge = 3600)
@RepositoryRestResource(path = "periods", exported = true)
public interface HOPeriodRepository  extends JpaRepository<HOPeriod, Long>{

}
