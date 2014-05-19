package com.starfarers.domain.map.system;

public enum PlanetType {
	TERRAN("terran"),
	ICE("ice"),
	MAGMA("magma"),
	DESERT("desert"),
	ARID("arid"),
	ROCKY("rocky"),
	JUNGLE("jungle"),
	CRYSTAL("crystal");

	private String value;

	PlanetType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public PlanetType getEnum(String planetTypeString) {
		for (PlanetType planetType : PlanetType.values()) {
			if (value.equals(planetTypeString)) {
				return planetType;
			}
		}
		return null;
	}

}
