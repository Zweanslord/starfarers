package com.starfarers.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starfarers.dao.GalaxyDao;
import com.starfarers.dao.SectorDao;
import com.starfarers.domain.map.Galaxy;
import com.starfarers.domain.map.Sector;
import com.starfarers.service.game.StarGenerator;

@Service
public class GalaxyService {

	@Autowired
	private GalaxyDao galaxyDao;

	@Autowired
	private SectorDao sectorDao;

	@Autowired
	private StarGenerator starGenerator;

	public Galaxy find(Integer galaxyId) {
		return galaxyDao.find(galaxyId);
	}

	public List<Galaxy> findAll() {
		return galaxyDao.findAll();
	}

	public Galaxy findOne() {
		return galaxyDao.findOne();
	}

	@Transactional
	public void remove(Integer galaxyId) {
		galaxyDao.remove(find(galaxyId));
	}

	public Galaxy save(Galaxy galaxy) {
		if (galaxy.getId() != null) {
			Galaxy originalGalaxy = find(galaxy.getId());
			if (originalGalaxy != null) {
				updateStars(originalGalaxy, galaxy);
			}
		}
		return galaxyDao.save(galaxy);
	}

	private void updateStars(Galaxy originalGalaxy, Galaxy galaxy) {
		for (Sector sector : galaxy.getSectors()) {
			Sector originalSector = originalGalaxy.findSector(sector.getId());
			if (originalSector != null) {
				updateStar(originalSector, sector);
			}
		}
	}

	private void updateStar(Sector originalSector, Sector sector) {
		if (originalSector.isStarSystem() && originalSector.hasStar() && sector.isStarSystem()) {
			sector.setStar(originalSector.getStar());
		} else if (!originalSector.isStarSystem() && sector.isStarSystem()) {
			sector.setStar(starGenerator.generate(sector));
		}
	}

}