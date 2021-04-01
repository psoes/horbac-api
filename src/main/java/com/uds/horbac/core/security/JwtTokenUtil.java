package com.uds.horbac.core.security;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;
import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.exceptions.ApiException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil implements Serializable{
	private static final long serialVersionUID = -2550185165626007488L;
	
	public static long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	
	static String key = Hashing.sha512().hashString("SQGno4yKamK1EdIsMsk", StandardCharsets.UTF_8).toString();
	
	/* to use later
	 * 
	final AES256TextEncryptor encryptor= new AES256TextEncryptor();
	encryptor.setPassword("randomPassword");
	//encrypt the text message
	encryptor.encrypt("message-encrpytion");
	
	//decrypt the message
	encryptor.decrypt("xxxs3233sdfadf");
	
	*/
	//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	private Key getSigningKey() {
		  byte[] keyBytes = Decoders.BASE64.decode(key);
		  return Keys.hmacShaKeyFor(keyBytes);
	}
	
	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	//retrive ip address from token
	public String getClientIpFromToken(String token) {
		return (String) getAllClaimsFromToken(token).get("ip");
	}
	
	//retrive ip address from token
	public String getClientAgentFromToken(String token) {
		return (String) getAllClaimsFromToken(token).get("agent");
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	    //for retrieving any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            new ApiException("Could not get all claims Token from passed token");
            claims = null;
        }
        return claims;
    }
	//check if the token has expired
	public Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	//generate token for user
	public String generateToken(User userDetails, String ip, String agent) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("ip", ip);
		claims.put("agent", agent);
		return doGenerateToken(claims, userDetails.getUsername());
	}
	//while creating the token -
	//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
	//2. Sign the JWT using the HS512 algorithm and secret key.
	//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	//   compaction of the JWT to a URL-safe string 
	private String doGenerateToken(Map<String, Object> claims, String subject) {		
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
		.signWith(getSigningKey()).compact();
	}
	//validate token
	
	public Boolean validateToken(String token, User userDetails, String ip, String agent) {
		final String username = getUsernameFromToken(token);
		boolean valid = username.equals(userDetails.getUsername()) 
				&& !isTokenExpired(token)
				&& ip.equals(getClientIpFromToken(token))
				&& agent.equals(getClientAgentFromToken(token));
		
		return valid;
	}
	
	
}
