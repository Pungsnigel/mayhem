package com.piggy.mayhem.entity.particle;

import java.awt.Rectangle;

import com.piggy.mayhem.entity.Entity;
import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.graphics.Sprite;
import com.piggy.mayhem.levels.tiles.Tile.TileType;

public class Particle extends Entity{
	
	private Sprite sprite;
	private int ticks;
	protected double xx,yy, zz;		// Positions
	protected double xa, ya, za;	// Speeds
	
	public Particle (int x, int y, int ticks, int color) {
		sprite = new Sprite(2,2, color);
		this.width = 2;
		this.height = 2;
		this.x = x;
		this.y = y;
		this.xx = x; 			// Need double precision in calculations
		this.yy = y;
		this.ticks = ticks;
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		this.zz = random.nextFloat() + 1.0;
	}
	
	public void update () {
		this.ticks--;
		if (this.ticks < 0) {
			remove();
		}
		
		// Bounce effect
		if (zz < 0) {
			zz = 0;
			za *= -0.55;
			xa *= 0.4;
			ya *= 0.4;
		}
		
		this.za -= 0.1;
		this.xx += this.xa;
		if (this.collision()) {
			xx -= 2*xa;
			xa *= -1;
		}
			
		this.yy += this.ya;
		if (this.collision()) {
			yy -= 2*ya;
			ya *= -1;
			za *= -1;
		}
		
		this.zz += this.za;
		
		this.x = (int)xx;
		this.y = (int)yy;
	}
	
	protected boolean collision() {
		boolean isColliding = false;
		Rectangle box = this.getCollisionBox();
		int maxY = (int)box.getMaxY() / 16;
		int minY = (int)box.getMinY() / 16;
		int minX = (int)box.getMinX() / 16;
		int maxX = (int)box.getMaxX() / 16;
		// Check collision for every corner
		if (level.getTile(maxX, maxY).type == TileType.collidable)
			isColliding = true;
		if (level.getTile(minX, maxY).type == TileType.collidable)
			isColliding = true;
		if (level.getTile(maxX, minY).type == TileType.collidable)
			isColliding = true;
		if (level.getTile(minX, minY).type == TileType.collidable)
			isColliding = true;
				
		return isColliding;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)(yy - zz), sprite, true);
	}
	
	@Override
	public void didCollide(Entity e) {
	}

}
