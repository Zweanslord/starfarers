package com.starfarers.service.game;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.starfarers.domain.map.system.Planet;
import com.starfarers.domain.map.system.PlanetType;
import com.starfarers.domain.map.system.Star;

@Component
public class PlanetGenerator {

	public Planet generate(Star star) {
		return generate(star, star.getPlanets().size() + 1);
	}

	public Planet generate(Star star, Integer position) {
		return new Planet(position, generatePlanetType(), new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(10), star);
	}

	private String generatePlanetType() {
		return PlanetType.values()[new Random().nextInt(PlanetType.values().length)].getValue();
	}

}