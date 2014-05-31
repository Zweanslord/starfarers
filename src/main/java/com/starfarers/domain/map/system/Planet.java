package com.starfarers.domain.map.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.starfarers.domain.common.Common;

@Entity
@Table
public class Planet extends Common {

	@Column(nullable = false)
	private Integer position;

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private Integer ore;

	@Column(nullable = false)
	private Integer gas;

	@Column(nullable = false)
	private Integer fertility;

	@ManyToOne
	@JoinColumn(name = "fk_star")
	private Star star;

	public Planet(Integer position, String type, Integer ore, Integer gas, Integer fertility, Star star) {
		this();
		this.position = position;
		this.type = type;
		this.ore = ore;
		this.gas = gas;
		this.fertility = fertility;
		this.star = star;
	}

	public Planet() {
		super();
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOre() {
		return ore;
	}

	public void setOre(Integer ore) {
		this.ore = ore;
	}

	public Integer getGas() {
		return gas;
	}

	public void setGas(Integer gas) {
		this.gas = gas;
	}

	public Integer getFertility() {
		return fertility;
	}

	public void setFertility(Integer fertility) {
		this.fertility = fertility;
	}

}