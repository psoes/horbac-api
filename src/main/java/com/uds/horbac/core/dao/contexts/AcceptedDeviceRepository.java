package com.uds.horbac.core.dao.contexts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uds.horbac.core.entities.contexts.AcceptedDevice;

import io.swagger.annotations.Api;

@Api(tags = "Accepted Device Type Entity")
@CrossOrigin(origins = "*",
	methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH },
maxAge = 3600)
@RepositoryRestResource(path = "accepted-devices", exported = true)
public interface AcceptedDeviceRepository  extends JpaRepository<AcceptedDevice, Long>{

}
