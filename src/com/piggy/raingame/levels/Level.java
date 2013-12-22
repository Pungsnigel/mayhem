package com.piggy.raingame.levels;
import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.levels.tiles.Tile;

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
		screen.setOffset(xScroll, yScroll);
		// FInd corners of screen from player,
		// Bitshift to convert from pixels to tiles (same as / 16)
		int x0 = xScroll / 16;		
		int x1 = (xScroll + screen.width + 16) / 16;
		int y0 = yScroll / 16;
		int y1 = (yScroll + screen.height + 16) / 16;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == 1) return Tile.trunk;
		return Tile.grass;
	}
	
	/* Private methods */
	
	
	private void loadLevel(String path) {
		
	}

	protected void generateRandomLevel() {
		
	}
	
	private void time () {
		
	}
	
}
