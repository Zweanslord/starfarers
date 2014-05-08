package com.starfarers.service.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.starfarers.domain.map.Galaxy;

public class GalaxyGeneratorTest {

	@Test
	public void testGalaxyGenerator() {
		int radius = 10;
		GalaxyGenerator galaxyGenerator = new GalaxyGenerator();
		Galaxy galaxy = galaxyGenerator.generate(new GalaxyFeatures(radius));
		assertNotNull(galaxy);
		assertEquals(1 + 6 * (radius + 1) * radius / 2, galaxy.getSectors().size());
	}

}