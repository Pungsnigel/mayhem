package com.piggy.raingame.levels.tiles;

import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.graphics.Sprite;

public class Tile {
	
	public int x,y;
	public Sprite sprite;

	public Tile (Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean collidable() {
		return false;
	}
}
