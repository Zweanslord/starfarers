package com.starfarers.dao;

import java.util.List;

import com.starfarers.domain.Player;

public interface PlayerDao extends BaseDao<Player> {

	List<Player> getPlayersByActive(boolean active);

}