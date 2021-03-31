package com.uds.horbac.core.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, String> {

	Optional<LoginAttempt> findByUsername(String username);

	void deleteByUsername(String username);

}
