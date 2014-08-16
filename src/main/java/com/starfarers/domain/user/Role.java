package com.starfarers.domain.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	PLAYER, GAME_MASTER, ADMINISTRATOR;

	public String getName() {
		return toString();
	}

	public String getValue() {
		return "ROLE_" + getName();
	}

	public String getAuthority() {
		return getValue();
	}

	public String getLowerCase() {
		return toString().toLowerCase();
	}

	public static Role toEnum(String value) {
		for (Role role : Role.values()) {
			if (role.getValue().equals(value)) {
				return role;
			}
		}
		return null;
	}

}