package com.starfarers.domain.map.system;

public class Planet {

	private Star star;

	private String type;

	public Planet(Star star, String type) {
		this();
		this.star = star;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}