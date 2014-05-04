package com.starfarers.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.starfarers.dao.PlayerDao;
import com.starfarers.domain.Player;

@Repository
public class PlayerDaoImpl extends BaseDaoImpl<Player> implements PlayerDao {

	@PersistenceContext
	private EntityManager entityManager;

	protected PlayerDaoImpl() {
		super(Player.class);
	}

	@Override
	public List<Player> getPlayersByActive(boolean active) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Player> criteriaQuery = criteriaBuilder.createQuery(Player.class);
		Root<Player> root = criteriaQuery.from(Player.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("active"), active));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}