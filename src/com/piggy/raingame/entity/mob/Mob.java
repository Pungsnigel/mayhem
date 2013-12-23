package com.piggy.raingame.entity.mob;

import com.piggy.raingame.entity.Entity;
import com.piggy.raingame.graphics.Sprite;

public abstract class Mob extends Entity{

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move(int dx, int dy) {
		if (dx > 0) dir = 1;
		if (dx < 0) dir = 3;
		if (dy > 0) dir = 2;
		if (dy < 0) dir = 0;
		
		if(!collision(dx, 0)) 
			this.x += dx;
		if(!collision(0, dy))
			this.y += dy;
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	private boolean collision(int dx, int dy) {
		boolean isColliding = false;
		// Check collision for every corner
		for (int c = 0; c < 4; c++) {
			int xt = ((x + dx) + c % 2 * 10 + 2) / 16;
			int yt = ((y + dy) + c / 2 * 10 - 2) / 16;
			if (level.getTile(xt, yt).collidable()) {
				isColliding = true;
			}
		}
				
		return isColliding;
	}
	
}
