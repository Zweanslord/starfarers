package com.starfarers.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.starfarers.dao.GalaxyDao;
import com.starfarers.domain.map.Galaxy;

@Repository
public class GalaxyDaoImpl extends BaseDaoImpl<Galaxy> implements GalaxyDao {

	@PersistenceContext
	private EntityManager entityManager;

	protected GalaxyDaoImpl() {
		super(Galaxy.class);
	}

	@Override
	@Transactional
	public Galaxy find(Integer id) {
		Galaxy galaxy = super.find(id);
		Hibernate.initialize(galaxy.getSectors());
		return galaxy;
	}

}