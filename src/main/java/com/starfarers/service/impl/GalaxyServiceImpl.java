package com.starfarers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starfarers.dao.SectorDao;
import com.starfarers.domain.map.Sector;
import com.starfarers.service.GalaxyService;

@Service
public class GalaxyServiceImpl implements GalaxyService {

	@Autowired
	private SectorDao sectorDao;

	@Override
	public Sector[][] getSectorRows() {

		// TODO Auto-generated method stub
		return null;
	}
}
