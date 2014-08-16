package com.starfarers.dao;

import java.util.List;

public interface BaseDao<T> {

	public void create(T entity);

	public T save(T entity);

	public void save(List<T> entities);

	public void remove(T entity);

	public T find(Integer id);

	public List<T> findAll();

	public <P> T findBy(String attribute, P parameter);

}