package com.starfarers.domain.map.system;

public class Planet {

	private Star star;

	private Integer position;

	private String type;

	private Integer ore;

	private Integer gas;

	private Integer fertility;

	public Planet(Star star, Integer position, String type, Integer ore, Integer gas, Integer fertility) {
		this();
		this.star = star;
		this.position = position;
		this.type = type;
		this.ore = ore;
		this.gas = gas;
		this.fertility = fertility;
	}

	Planet() {
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