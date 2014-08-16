package com.starfarers.dao;

import com.starfarers.domain.user.User;

public interface UserDao extends BaseDao<User> {

	User find(String userName);

}