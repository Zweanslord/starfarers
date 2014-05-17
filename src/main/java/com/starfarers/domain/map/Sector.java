package com.starfarers.domain.map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.starfarers.domain.common.Common;

@Entity
@Table
public class Sector extends Common {

	@Valid
	@Embedded
	private Coordinates coordinates;

	@NotNull
	@Column(nullable = false)
	private String terrain;

	private boolean starSystem;

	@ManyToOne
	@JoinColumn(name = "fk_galaxy", nullable = false)
	private Galaxy galaxy;

	public Sector(Coordinates coordinates, String terrain, boolean starSystem, Galaxy galaxy) {
		this();
		this.coordinates = coordinates;
		this.terrain = terrain;
		this.starSystem = starSystem;
		this.galaxy = galaxy;
	}

	Sector() {
		super();
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public boolean isStarSystem() {
		return starSystem;
	}

	public void setStarSystem(boolean starSystem) {
		this.starSystem = starSystem;
	}

	public Galaxy getGalaxy() {
		return galaxy;
	}

	public void setGalaxy(Galaxy galaxy) {
		this.galaxy = galaxy;
	}

}