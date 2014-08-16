package com.starfarers.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.starfarers.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> entityClass;

	protected BaseDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public void create(T entity) {
		entityManager.persist(entity);
	}

	@Transactional
	public T save(T entity) {
		T savedEntity = entityManager.merge(entity);
		entityManager.flush();
		return savedEntity;
	}

	@Transactional
	public void save(List<T> entities) {
		List<T> savedEntities = new ArrayList<>();
		for (T entity : entities) {
			savedEntities.add(save(entity));
		}
		// return entities;
	}

	@Transactional
	public void remove(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	public T find(Integer id) {
		return entityManager.find(entityClass, id);
	}

	public List<T> findAll() {
		CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(entityClass);
		criteriaQuery.select(criteriaQuery.from(entityClass));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public <P> T findBy(String attribute, P parameter) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

		Root<T> root = criteriaQuery.from(entityClass);

		@SuppressWarnings("unchecked")
		ParameterExpression<P> parameterExpression = (ParameterExpression<P>) criteriaBuilder.parameter(parameter.getClass());

		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(attribute), parameterExpression));

		TypedQuery<T> query = entityManager.createQuery(criteriaQuery).setParameter(parameterExpression, parameter).setMaxResults(1);

		return getSingleResult(query);
	}

	private T getSingleResult(TypedQuery<T> query) {
		List<T> results = query.getResultList();
		T result = null;
		if (results.size() > 0) {
			result = results.get(0);
		}
		return result;
	}

}