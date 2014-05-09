package com.starfarers.dao.impl;

import org.springframework.stereotype.Repository;

import com.starfarers.dao.GalaxyDao;
import com.starfarers.domain.map.Galaxy;

@Repository
public class GalaxyDaoImpl extends BaseDaoImpl<Galaxy> implements GalaxyDao {

	protected GalaxyDaoImpl() {
		super(Galaxy.class);
	}

}