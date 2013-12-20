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
		
		if(!collision()) {
			this.x += dx;
			this.y += dy;
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	private boolean collision() {
		return false;
	}
	
}
