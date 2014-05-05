package com.starfarers.domain.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.starfarers.domain.common.Common;

@Entity
@Table
public class Galaxy extends Common {

	@Column
	private Integer radius;

	@OneToMany(mappedBy = "galaxy")
	private List<Sector> sectors;

	public Galaxy(Integer radius) {
		this();
		this.radius = radius;
	}

	Galaxy() {
		super();
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