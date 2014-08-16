package com.starfarers.domain.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.userdetails.UserDetails;

import com.starfarers.domain.common.Common;

@Entity
@Table
public class User extends Common implements UserDetails {

	private static final long serialVersionUID = -3566351492453779568L;

	@NotNull
	@Size(min = 8, max = 30)
	@Column(nullable = false, unique = true)
	private String username = "";

	@Column(nullable = false)
	private String password;

	private boolean enabled = true;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
	private Set<UserRole> userRoles = new HashSet<UserRole>();

	public User(String password) {
		this();
		this.password = password;
	}

	User() {
		super();
	}

	@Override
	public String toString() {
		return username;
	}

	public void addUserRole(Role role) {
		userRoles.add(new UserRole(this, role));
	}

	public Set<Role> getRoles() {
		Set<Role> roles = new HashSet<Role>();
		for (UserRole userRole : userRoles) {
			roles.add(userRole.getRole());
		}
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		for (Role role : Role.values()) {
			if (!has(role) && roles.contains(role)) {
				addUserRole(role);
			} else if (has(role) && !roles.contains(role)) {
				removeUserRole(role);
			}
		}
	}

	public boolean has(Role role) {
		boolean result = false;
		for (UserRole userRole : userRoles) {
			if (userRole.getRole().equals(role)) {
				result = true;
				break;
			}
		}
		return result;
	}

	private void removeUserRole(Role role) {
		for (UserRole userRole : userRoles) {
			if (userRole.getRole().equals(role)) {
				userRoles.remove(userRole);
				break;
			}
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	/* UserDetails methods */

	public Set<Role> getAuthorities() {
		return getRoles();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

}