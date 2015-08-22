package com.starfarers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starfarers.dao.SpeciesDao;
import com.starfarers.domain.species.Species;

@Service
public class SpeciesService {

	@Autowired
	private transient SpeciesDao speciesDao;

	public Species save(Species species) {
		return speciesDao.save(species);
	}

}