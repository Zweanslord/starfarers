package com.starfarers.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starfarers.dao.GalaxyDao;

@Service
public class GalaxyService {

	@Autowired
	private GalaxyDao galaxyDao;

	@Transactional
	public void removeGalaxy(Integer id) {
		galaxyDao.remove(galaxyDao.find(id));
	}
}