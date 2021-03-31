package com.uds.horbac.core.entities.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.uds.horbac.core.entities.employees.Employee;

import lombok.Data;


@Entity
@Table(name="ho_user")
@Data
public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="The username name is required")
	@Column(length=150, unique=true)
	private String username;
	
	@NotNull(message="The password name is required")
	@Column(length=150)
	private String password;
	
	@NotNull(message="The property active is required")
	private Boolean active;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private boolean enabled;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		 List<GrantedAuthority> autorities = new ArrayList<>();	   
	     return autorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	@Override
	public String toString() {
		return username;
	}
   
	public static boolean isNotAdmin(User u) {
		return u.getId() != 1;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
}
