package com.piggy.raingame.entity;

import java.util.Random;

import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.levels.Level;

public abstract class  Entity  {
	
	public int x,y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
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
	
}
