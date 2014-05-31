package com.starfarers.dao;

import com.starfarers.domain.map.Coordinates;
import com.starfarers.domain.map.system.Star;

public interface StarDao extends BaseDao<Star> {

	Star findStarByGalaxyIdAndCoordinates(Integer galaxyId, Coordinates coordinates);

}