package com.starfarers.domain.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.starfarers.domain.common.Common;

@Entity
@Table
public class Galaxy extends Common {

	@NotNull
	@Min(1)
	@Max(30)
	private Integer radius;

	// TODO add validation: unique coordinates, within radius size, expected nr of sectors based on radius
	@Valid
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "galaxy")
	private List<Sector> sectors;

	public Galaxy(Integer radius) {
		this();
		this.radius = radius;
	}

	public Galaxy() {
		super();
	}

	public Sector findSector(int id) {
		for (Sector sector : sectors) {
			if (sector.getId().equals(id)) {
				return sector;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Galaxy [id=" + getId() + ", radius=" + radius + "]";
	}

	public Integer getRadius() {
		return radius;
	}

	public List<Sector> getSectors() {
		return sectors;
	}

	public Galaxy setSectors(List<Sector> sectors) {
		this.sectors = sectors;
		return this;
	}

}