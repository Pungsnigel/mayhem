package com.piggy.raingame.levels.tiles;

import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.graphics.Sprite;

public class TrunkTile extends Tile{
	
	public TrunkTile(Sprite sprite, TileType type) {
		super(sprite, type);
	}

	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x * 16, y * 16, this.sprite);
	}
	
	@Override
	public boolean collidable() {
		return true;
	}
}
