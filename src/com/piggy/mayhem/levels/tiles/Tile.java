package com.piggy.mayhem.levels.tiles;

import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.graphics.Sprite;

public class Tile {
	
	public enum TileType {walkable, collidable, unwalkable};
	
	public int x,y;
	public Sprite sprite;
	public TileType type;

	public Tile (Sprite sprite, TileType type) {
		this.sprite = sprite;
		this.type = type;
	}
	
	public void render(int x, int y, Screen screen) {
	}
}
