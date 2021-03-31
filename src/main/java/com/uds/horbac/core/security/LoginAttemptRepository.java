package com.uds.horbac.core.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginAttemptRepository extends CrudRepository<LoginAttempt, String> {

	Optional<LoginAttempt> findByUserName(String username);

	void deleteByUserName(String username);

}
