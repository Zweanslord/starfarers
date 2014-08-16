package com.starfarers.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.starfarers.domain.common.Common;

@Entity
@Table
public class UserRole extends Common {

	@ManyToOne
	@JoinColumn(name = "fk_user", nullable = false)
	private User user;

	@Column(nullable = false)
	private String role;

	public UserRole(User user, Role role) {
		this();
		this.user = user;
		setRole(role);
	}

	UserRole() {
		super();
	}

	@Override
	public String toString() {
		return user.getUsername() + ", " + role.toString();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return Role.toEnum(role);
	}

	public void setRole(Role role) {
		this.role = role.getValue();
	}

}