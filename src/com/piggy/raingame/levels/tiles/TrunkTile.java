package com.piggy.raingame.levels.tiles;

import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.graphics.Sprite;

public class TrunkTile extends Tile{
	
	public TrunkTile(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x * 16, y * 16, this);
	}
	
	@Override
	public boolean collidable() {
		return true;
	}
}
