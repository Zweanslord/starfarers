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
		starFormation(galaxy);
		return galaxyDao.save(galaxy);
	}

	private void starFormation(Galaxy galaxy) {
		for (Sector sector : galaxy.getSectors()) {
			refreshStar(sector);
			if (sector.isStarSystem() && !sector.hasStar()) {
				sector.setStar(starGenerator.generate(sector));
			} else if (!sector.isStarSystem() && sector.hasStar()) {
				sector.setStar(null);
			}
		}
	}

	private void refreshStar(Sector sector) {
		Integer id = sector.getId();
		if (id != null) {
			Sector foundSector = sectorDao.find(id);
			if (foundSector != null) {
				sector.setStar(foundSector.getStar());
			}
		}
	}

}