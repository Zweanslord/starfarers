package com.starfarers.domain.map;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Coordinates {

	private static final Integer[][] NEIGHBOURS = { { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 } };

	@Column(nullable = false)
	private Integer x;

	@Column(nullable = false)
	private Integer y;

	public Coordinates(Integer x, Integer y) {
		this();
		this.x = x;
		this.y = y;
	}

	Coordinates() {
		super();
	}

	@Transient
	public Coordinates getNeighbour(Integer direction) {
		Integer[] d = NEIGHBOURS[direction];
		return new Coordinates(x + d[0], y + d[1]);
	}

	@Transient
	public Integer getZ() {
		return 0 - x - y;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

}