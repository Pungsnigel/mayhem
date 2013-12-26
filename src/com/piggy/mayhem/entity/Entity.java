package com.piggy.mayhem.entity;

import java.awt.Rectangle;
import java.util.Random;
import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.levels.Level;

public abstract class Entity {
	
	public int x,y, width, height;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	/**
	 * Calculates a collision box for the entity.
	 * @return
	 */
	public Rectangle getCollisionBox() {
		return new Rectangle(x, y, width, height);
	}
	
	public boolean isColliding (Entity other) {
		if (other == this) return false;
		return this.getCollisionBox().intersects(other.getCollisionBox());
	}
	
	public void update () {
		
	}
	
	public void render(Screen screen) {
	}
	
	public void remove () {
		this.removed = true;
	}
	
	public boolean isRemoved() {
		return this.removed;
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
	public abstract void didCollide(Entity e);
	
}
