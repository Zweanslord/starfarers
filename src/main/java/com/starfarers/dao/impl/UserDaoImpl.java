package com.starfarers.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.starfarers.dao.UserDao;
import com.starfarers.domain.user.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	protected UserDaoImpl() {
		super(User.class);
	}

	public User find(String username) {
		return findBy("username", username);
	}
}