package com.starfarers.domain.map;

import java.util.List;

public class SectorRow {

	private Integer coordinate;

	private List<Sector> row;

	public SectorRow(Integer coordinate, List<Sector> row) {
		this.coordinate = coordinate;
		this.row = row;
	}

	public Integer getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Integer coordinate) {
		this.coordinate = coordinate;
	}

	public List<Sector> getRow() {
		return row;
	}

	public void setRow(List<Sector> row) {
		this.row = row;
	}

}