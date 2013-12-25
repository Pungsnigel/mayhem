package com.piggy.mayhem.levels;

public class TileCoordinate {
	
	private int x,y;
	private final int TILE_SIZE = 16;
	
	public TileCoordinate(int x, int y) {
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int[] getXY() {
		int [] res = {x,y};
		return res;
	}
}
