package com.piggy.raingame.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.piggy.raingame.entity.projectile.Projectile;
import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.levels.Level;

public abstract class Entity {
	
	public int x,y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	protected List<Projectile> projectiles = new ArrayList<Projectile>();

	
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
	
}
