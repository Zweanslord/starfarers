package com.starfarers.dao.impl;

import org.springframework.stereotype.Repository;

import com.starfarers.dao.SpeciesDao;
import com.starfarers.domain.species.Species;

@Repository
public class SpeciesDaoImpl extends BaseDaoImpl<Species> implements SpeciesDao {

	protected SpeciesDaoImpl() {
		super(Species.class);
	}

}
