package com.piggy.mayhem.entity.mob;

import java.awt.Rectangle;

import com.piggy.mayhem.entity.Entity;
import com.piggy.mayhem.entity.projectile.CoffeeCup;
import com.piggy.mayhem.graphics.Sprite;
import com.piggy.mayhem.levels.tiles.Tile.TileType;

public abstract class Mob extends Entity{

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	protected int lastX, lastY;
	
	public Mob(int x, int y, int width, int height) {
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
	}
	
	public void move(int dx, int dy) {
		if (dx > 0) dir = 1;
		if (dx < 0) dir = 3;
		if (dy > 0) dir = 2;
		if (dy < 0) dir = 0;
		
		lastX = x;
		lastY = y;
		
		x += dx;
		if(collision())
			this.x -= dx;
		y += dy;
		if(collision())
			this.y -= dy;
		
	}
	
	public void update() {
	}

	
	public void render() {
		
	}
	
	private boolean collision() {
		boolean isColliding = false;
		Rectangle box = this.getCollisionBox();
		int maxY = (int)box.getMaxY() / 16;
		int minY = (int)box.getMinY() / 16;
		int minX = (int)box.getMinX() / 16;
		int maxX = (int)box.getMaxX() / 16;
		// Check collision for every corner
		if (level.getTile(maxX, maxY).type != TileType.walkable)
			isColliding = true;
		if (level.getTile(minX, maxY).type != TileType.walkable)
			isColliding = true;
		if (level.getTile(maxX, minY).type != TileType.walkable)
			isColliding = true;
		if (level.getTile(minX, minY).type != TileType.walkable)
			isColliding = true;
				
		return isColliding;
	}
	
	protected void shoot(int x, int y, double dir) {
		level.add(new CoffeeCup(x, y, dir, this));
	}
	
}
