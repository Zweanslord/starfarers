package com.starfarers.dao;

import java.util.List;

public interface BaseDao<T> {

	public void create(T entity);

	public T save(T entity);

	public void saveAll(List<T> entities);

	public void remove(T entity);

	public T find(Long id);

	public List<T> findAll();

}