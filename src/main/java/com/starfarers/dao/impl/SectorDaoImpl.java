package com.starfarers.dao.impl;

import org.springframework.stereotype.Repository;

import com.starfarers.dao.SectorDao;
import com.starfarers.domain.map.Sector;

@Repository
public class SectorDaoImpl extends BaseDaoImpl<Sector> implements SectorDao {

	protected SectorDaoImpl() {
		super(Sector.class);
	}

}