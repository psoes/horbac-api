package com.uds.horbac.core.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRepository extends CrudRepository<Jwt, String>{

}
