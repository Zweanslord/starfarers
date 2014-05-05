package com.starfarers.domain.map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.starfarers.domain.common.Common;

@Entity
@Table
public class Sector extends Common {

	@Embedded
	private Coordinates coordinates;

	@Column(nullable = false)
	private String terrain;

	@ManyToOne
	@JoinColumn(name = "fk_galaxy", nullable = false)
	private Galaxy galaxy;

	public Sector(Coordinates coordinates, String terrain, Galaxy galaxy) {
		this();
		this.coordinates = coordinates;
		this.terrain = terrain;
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

	public Galaxy getGalaxy() {
		return galaxy;
	}

	public void setGalaxy(Galaxy galaxy) {
		this.galaxy = galaxy;
	}

}