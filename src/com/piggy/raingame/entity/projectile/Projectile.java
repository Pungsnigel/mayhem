package com.piggy.raingame.entity.projectile;

import com.piggy.raingame.entity.Entity;
import com.piggy.raingame.graphics.Sprite;

public abstract class Projectile extends Entity {
	
	protected final int xOrig, yOrig;
	protected double angle;
	protected Sprite sprite;
	protected double vecX, vecY;
	protected double speed, rateOfFire, dmg, range;
	
	public Projectile (int x, int y, double dir ) {
		this.x = xOrig = x;
		this.y = yOrig = y;
		angle = dir;
	}
	
}
