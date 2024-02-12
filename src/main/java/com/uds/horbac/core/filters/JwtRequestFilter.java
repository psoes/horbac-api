package com.uds.horbac.core.filters;

import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.security.JwtTokenUtil;
import com.uds.horbac.core.service.users.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private String ip;
	
	private String agent;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		ip = request.getRemoteAddr();
		agent = request.getHeader("User-Agent");
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				logger.warn("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				logger.warn("JWT Token has expired");
			}
		} else if(requestTokenHeader == null){
			logger.warn("pas de header !!!");
		}
		else {
			logger.warn("JWT Token does not begin with Bearer String");
		}
			// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			User userDetails = userService.loadUserByUsername(username);
			// if token is valid configure Spring Security to manually set
			// authentication
		if (jwtTokenUtil.validateToken(jwtToken, userDetails, ip, agent)) {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			// After setting the Authentication in the context, we specify
			// that the current user is authenticated. So it passes the
			// Spring Security Configurations successfully.
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		
		}
		chain.doFilter(request, response);
	}
	
	
}