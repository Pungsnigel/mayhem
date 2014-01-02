package com.piggy.mayhem.entity.projectile;

import java.awt.Rectangle;
import java.util.Random;
import com.piggy.mayhem.entity.Entity;
import com.piggy.mayhem.entity.mob.Mob;
import com.piggy.mayhem.graphics.Sprite;
import com.piggy.mayhem.levels.tiles.Tile.TileType;

public abstract class Projectile extends Entity {
	
	public static final Random rand = new Random();
	
	protected Mob owner;
	protected final int xOrig, yOrig;
	protected double angle;
	protected Sprite sprite;
	// Override positions from entity, need more precision to follow projectile-path
	protected  double x,y ; 		
	protected double vecX, vecY;
	protected double speed, dmg, range;
	
	public Projectile (int x, int y, int width, int height, double dir, Mob owner) {
		this.x = this.xOrig = x;
		this.y = this.yOrig = y;
		this.width = width;
		this.height = height;
		angle = dir;
		this.owner = owner;
	}
	
	public void update() {
		if (distanceTravelled() > this.range) {
			this.remove();
		}
	}
	
	
	//TODO should probably be abstract? All projectiles will prob need a offset etc.
	public Rectangle getCollisionBox() {
		return new Rectangle((int)x, (int)y, width, height);
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
	
	public void remove () {
		super.remove();
	}
	
	/**
	 * calculate the total distance traveled in pixels
	 * @return the distance
	 */
	private double distanceTravelled() {
		double xDiff = (xOrig - x) * (xOrig - x);
		double yDiff = (yOrig - y) * (yOrig - y);
		// Use pythagoras theorem with the values to get total distance traveled.
		return Math.sqrt( Math.abs( xDiff + yDiff )); 
	}
	
}
