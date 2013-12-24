package com.piggy.raingame.entity.projectile;

import java.util.Random;

import com.piggy.raingame.entity.Entity;
import com.piggy.raingame.graphics.Sprite;

public abstract class Projectile extends Entity {
	
	public static final Random rand = new Random();
	
	protected final int xOrig, yOrig;
	protected double angle;
	protected Sprite sprite;
	// Override positions from entity, need more precision to follow projectile-path
	protected  double x,y ; 		
	protected double vecX, vecY;
	protected double speed, dmg, range;
	
	public Projectile (int x, int y, double dir ) {
		this.x = xOrig = x;
		this.y = yOrig = y;
		angle = dir;
	}
	
	public void update() {
		if (distanceTravelled() > this.range)
			this.remove();
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
