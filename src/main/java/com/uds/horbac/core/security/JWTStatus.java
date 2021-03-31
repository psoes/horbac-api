package com.uds.horbac.core.security;

/**
 * enum type to keep the jwt status
 * @author Fidèle
 *
 */
public enum JWTStatus {
	
	USER_DISABLED, BAD_CREDENTIALS, AUTHENTICATED, ACCOUNT_LOCKED, ACCOUNT_EXPIRED, ATTEMPT_LIMIT_REACHED, UNKNOWN_ERROR, ACCOUNT_NOT_FOUND
}
