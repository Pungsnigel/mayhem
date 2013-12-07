package com.piggy.raingame.levels;

import com.piggy.raingame.graphics.Screen;

public abstract class Level {
	
	protected int width, height;
	protected int [] tiles;
	
	/**
	 * Create a random level of given size
	 * @param width
	 * @param height
	 */
	public  Level(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new int [width * height];
		generateRandomLevel();
	}

	/**
	 * Load a level from a file
	 * @param path
	 */
	public Level(String path) {
		loadLevel(path);
	}
	

	public void update() {
		
	}
	

	
	public void render(int xScroll, int yScroll, Screen screen) {
		
	}
	
	/* Private methods */
	
	
	private void loadLevel(String path) {
		
	}

	protected void generateRandomLevel() {
		
	}
	
	private void time () {
		
	}
	
}
