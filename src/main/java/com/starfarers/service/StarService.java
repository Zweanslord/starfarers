package com.starfarers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starfarers.dao.StarDao;
import com.starfarers.domain.map.Coordinates;
import com.starfarers.domain.map.system.Planet;
import com.starfarers.domain.map.system.Star;

@Service
public class StarService {

	@Autowired
	private transient StarDao starDao;

	public Star findStarByGalaxyIdAndCoordinates(Integer galaxy, Coordinates coordinates) {
		return starDao.findStarByGalaxyIdAndCoordinates(galaxy, coordinates);
	}

	public Star save(Integer galaxyId, Coordinates coordinates, Star star) {
		star.setSector(starDao.findStarByGalaxyIdAndCoordinates(galaxyId, coordinates).getSector());
		for (Planet planet : star.getPlanets()) {
			planet.setStar(star);
		}
		return starDao.save(star);
	}

}