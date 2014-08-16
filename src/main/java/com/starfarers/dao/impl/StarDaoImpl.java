package com.starfarers.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.springframework.stereotype.Repository;

import com.starfarers.dao.StarDao;
import com.starfarers.domain.map.Coordinates;
import com.starfarers.domain.map.Galaxy;
import com.starfarers.domain.map.Sector;
import com.starfarers.domain.map.system.Star;

@Repository
public class StarDaoImpl extends BaseDaoImpl<Star> implements StarDao {

	private static final Class<Star> entityClass = Star.class;

	@PersistenceContext
	private EntityManager entityManager;

	protected StarDaoImpl() {
		super(entityClass);
	}

	public Star findStarByGalaxyIdAndCoordinates(Integer galaxyId, Coordinates coordinates) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Star> criteriaQuery = criteriaBuilder.createQuery(entityClass);

		Root<Star> starRoot = criteriaQuery.from(entityClass);

		Metamodel metaModel = entityManager.getMetamodel();
		EntityType<Star> starMeta = metaModel.entity(entityClass);
		EntityType<Sector> sectorMeta = metaModel.entity(Sector.class);

		Join<Star, Sector> sectorJoin = starRoot.join(starMeta.getSingularAttribute("sector", Sector.class));
		Join<Sector, Galaxy> galaxyJoin = sectorJoin.join(sectorMeta.getSingularAttribute("galaxy", Galaxy.class));

		List<Predicate> predicates = new ArrayList<>();
		predicates.add(criteriaBuilder.equal(galaxyJoin.get("id"), galaxyId));
		predicates.add(criteriaBuilder.equal(sectorJoin.get("coordinates"), coordinates));

		criteriaQuery.select(starRoot);
		criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

		List<Star> stars = entityManager.createQuery(criteriaQuery).setMaxResults(1).getResultList();
		Star result = null;
		if (stars.size() > 0) {
			result = stars.get(0);
		}
		return result;
	}

}