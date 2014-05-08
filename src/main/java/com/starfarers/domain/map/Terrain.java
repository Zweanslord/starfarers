package com.starfarers.domain.map;

public enum Terrain {
	SPACE("space"),
	STAR("star"),
	ASTEROIDS("asteroids"),
	VOLATILE_NEBULA("volatile nebula"),
	SHROUDING_NEBULA("shrouding nebula"),
	RESONATING_NEBULA("resonating nebula"),
	IONIC_NEBULA("ionic nebula"),
	RIFTS("rifts"),
	GRAVITY_WELL("gravity well");

	private String value;

	Terrain(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public Terrain getEnum(String terrainString) {
		for (Terrain terrain : Terrain.values()) {
			if (value.equals(terrainString)) {
				return terrain;
			}
		}
		return null;
	}
}