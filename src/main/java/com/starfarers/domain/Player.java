package com.starfarers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.starfarers.domain.common.Common;

@Entity
@Table
public class Player extends Common {

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private boolean active = true;

	public Player() {
		super();
	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return name;
	}

}