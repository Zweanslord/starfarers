package com.starfarers.dao.impl;

import org.springframework.stereotype.Repository;

import com.starfarers.dao.PlayerDao;
import com.starfarers.domain.Player;

@Repository
public class PlayerDaoImpl extends BaseDaoImpl<Player> implements PlayerDao {

	protected PlayerDaoImpl() {
		super(Player.class);
	}

}