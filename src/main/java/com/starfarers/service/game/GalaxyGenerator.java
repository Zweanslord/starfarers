package com.starfarers.service.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.starfarers.domain.map.Coordinates;
import com.starfarers.domain.map.Galaxy;
import com.starfarers.domain.map.Sector;
import com.starfarers.domain.map.Terrain;

@Component
public class GalaxyGenerator {

	public Galaxy generate(GalaxyFeatures galaxyFeatures) {
		Integer radius = galaxyFeatures.getRadius();
		Galaxy galaxy = new Galaxy(radius);
		List<Sector> sectors = new ArrayList<>();
		Coordinates coordinates = new Coordinates(0, 0);
		sectors.add(new Sector(new Coordinates(0, 0), getRandomTerrain(), false, galaxy));
		for (int r = 1; r <= radius; r++) {
			coordinates = coordinates.getNeighbour(4);
			for (int h = 0; h < 6; h++) {
				for (int line = 0; line < r; line++) {
					coordinates = coordinates.getNeighbour(h);
					boolean starSystem = new Random().nextBoolean();
					sectors.add(new Sector(coordinates, getRandomTerrain(), starSystem, galaxy));
				}
			}
		}
		return galaxy.setSectors(sectors);
	}

	private String getRandomTerrain() {
		return Terrain.values()[new Random().nextInt(Terrain.values().length)].getValue();
	}

}