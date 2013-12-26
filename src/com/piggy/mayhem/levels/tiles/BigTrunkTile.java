package com.piggy.mayhem.levels.tiles;

import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.graphics.Sprite;

public class BigTrunkTile extends Tile{

	public BigTrunkTile(Sprite sprite, TileType type) {
		super(sprite, type);
	}
	
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x * 16, y * 16, this.sprite);
	}

}
