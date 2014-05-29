package com.starfarers.domain.map.system;

import java.util.List;

import com.starfarers.domain.map.Sector;

public class Star {

	private Sector sector;

	private List<Planet> planets;

	public Star(Sector sector) {
		this();
		this.sector = sector;
	}

	Star() {
		super();
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

}