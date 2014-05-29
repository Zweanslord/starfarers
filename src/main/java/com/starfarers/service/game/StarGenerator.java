package com.starfarers.service.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.starfarers.domain.map.Sector;
import com.starfarers.domain.map.system.Planet;
import com.starfarers.domain.map.system.PlanetType;
import com.starfarers.domain.map.system.Star;

@Component
public class StarGenerator {

	public Star generate(Sector sector) {
		Star star = new Star(sector);
		star.setPlanets(generatePlanets(star));
		return star;
	}

	private List<Planet> generatePlanets(Star star) {
		Integer amountOfPlanets = new Random().nextInt(10);
		List<Planet> planets = new ArrayList<>();
		for (int position = 1; position <= amountOfPlanets; position++) {
			planets.add(new Planet(star, position, generatePlanetType(), new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(10)));
		}
		return planets;
	}

	private String generatePlanetType() {
		return PlanetType.values()[new Random().nextInt(PlanetType.values().length)].getValue();
	}

}