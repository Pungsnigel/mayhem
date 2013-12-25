package com.piggy.raingame.levels.tiles;

import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.graphics.Sprite;

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
	
	public boolean collidable() {
		return false;
	}
}
