package com.starfarers.domain.map.system;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StarTest {

	@Test
	public void testRemovePlanet() {
		Star star = new Star();
		List<Planet> planets = new ArrayList<>();
		planets.add(new Planet(1, null, null, null, null, star));
		planets.add(new Planet(2, null, null, null, null, star));
		planets.add(new Planet(3, null, null, null, null, star));
		star.setPlanets(planets);
		star.removePlanet(2);

		assertEquals(2, star.getPlanets().size());
		assertEquals(Integer.valueOf(2), star.getPlanets().get(1).getPosition());
	}

}
