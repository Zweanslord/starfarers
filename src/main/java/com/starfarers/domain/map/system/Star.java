package com.starfarers.domain.map.system;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import com.starfarers.domain.common.Common;
import com.starfarers.domain.map.Sector;

@Entity
@Table
public class Star extends Common {

	@OneToOne
	@JoinColumn(name = "fk_sector", nullable = false)
	private Sector sector;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "star")
	private List<Planet> planets;

	public Star(Sector sector) {
		this();
		this.sector = sector;
	}

	Star() {
		super();
	}

	public void addPlanet(Planet planet) {
		planets.add(planet);
	}

	@Override
	public String toString() {
		return "Star [id=" + getId() + ", planets=" + planets.size() + "]";
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