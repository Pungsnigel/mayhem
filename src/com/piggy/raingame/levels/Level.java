package com.piggy.raingame.levels;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.piggy.raingame.entity.Entity;
import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.levels.tiles.Tile;
import com.piggy.raingame.levels.tiles.Tiles;

public class Level {
	
	public static SpawnLevel example = new SpawnLevel("/levels/LvL.png");
	
	private Random rand = new Random();
	protected int width, height;
	protected int [] tiles;
	protected int [] tileInts;
	
	private List <Entity> entities = new ArrayList<Entity>();
	
	
	/**
	 * Create a random level of given size
	 * @param width
	 * @param height
	 */
	public  Level(int width, int height) {
		this.width = width;
		this.height = height;
		generateLevel();
	}

	/**
	 * Load a level from a file
	 * @param path
	 */
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.update();
			if (e.isRemoved())
				entities.remove(i);
		}
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
				getTile(x,y).render(x, y, screen);
			}	
		}
		
		for (Entity e : entities) {
			e.render(screen);
		}
	}
	
	public Tile getTile(int x, int y) {
		int index = x + y * width;
		if (x < 0 || y < 0 || x >= width || y >= height) return Tiles.voidTile;
		if (tiles[index] == Tiles.grassColor)  return Tiles.grass;
		if (tiles[index] == Tiles.waterColor)  return Tiles.water;
		if (tiles[index] == Tiles.trunkColor)  return Tiles.trunk;
		if (tiles[index] == Tiles.flowerColor) return Tiles.flowerGrass;
		return Tiles.voidTile;
	}
	
	public void add(Entity e) {
		entities.add(e);
	}
	
	public void remove(Entity e) {
		entities.remove(e);
	}
	
	/* Private methods */
	
	
	protected void loadLevel(String path) {
		
	}

	protected void generateLevel() {
		
	}
	
	private void time () {
		
	}
	
}
