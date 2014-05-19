package com.starfarers.service.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.starfarers.domain.map.system.Planet;
import com.starfarers.domain.map.system.PlanetType;
import com.starfarers.domain.map.system.Star;

@Component
public class StarGenerator {

	public Star generate() {
		Star star = new Star();
		star.setPlanets(generatePlanets(star));
		return star;
	}

	private List<Planet> generatePlanets(Star star) {
		Integer amountOfPlanets = new Random().nextInt(10);
		List<Planet> planets = new ArrayList<>();
		for (int i = 0; i < amountOfPlanets; i++) {
			planets.add(new Planet(star, generatePlanetType()));
		}
		return planets;
	}

	private String generatePlanetType() {
		return PlanetType.values()[new Random().nextInt(PlanetType.values().length)].getValue();
	}

}