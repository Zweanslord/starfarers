package com.starfarers.service.game;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GalaxyFeatures {

	@NotNull
	@Min(1)
	@Max(30)
	private Integer radius;

	protected GalaxyFeatures() {

	}

	public GalaxyFeatures(Integer radius) {
		this.radius = radius;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

}