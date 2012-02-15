package com.tour.tile;

public class Tile {
	/*
	 * 0 - Empty Space
	 * 1 - Visited Space
	 * 2 - Knight
	 * 3 - Valid Move Space
	 */
	private int tileType;
	
	/*
	 * E - Empty Space
	 * X - Visited Space
	 * K - Knight
	 * V - Valid Move Space
	 */
	private Character tileMark;
	
	private boolean visited;
	
	public Tile() {
		tileType = 0;
		tileMark = 'E';
		visited = false;
	}
	
	public Tile(int type) {
		tileType = type;
		tileMark = (type == 0)?'E':((type == 1)?'X':((type == 2)?'K':((type == 3)?'V':'O')));
		visited = false;
	}
	
	public int getType() {
		return this.tileType;
	}
	
	public void setType(int type) {
		this.tileType = type;
		this.setMark(type);
	}
	
	public Character getMark() {
		return this.tileMark;
	}
	
	private void setMark(int type) { // Should only be called by setType() internally.
		this.tileMark = (type == 0)?'E':((type == 1)?'X':((type == 2)?'K':((type == 3)?'V':'O')));
	}
	
	public boolean hasBeenVisited() {
		return this.visited;
	}
	
	public void visit() {
		this.visited = true;
		this.setType(1);
	}
}
