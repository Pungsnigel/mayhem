package com.piggy.mayhem.levels;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.piggy.mayhem.entity.Entity;
import com.piggy.mayhem.entity.particle.Particle;
import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.levels.tiles.Tile;
import com.piggy.mayhem.levels.tiles.Tiles;

public class Level {
	
	public static SpawnLevel example = new SpawnLevel("/levels/LvL.png");
	
	private Random rand = new Random();
	protected int width, height;
	protected int [] tiles;
	protected int [] tileInts;
	
	private List <Entity> entities = new ArrayList<Entity>();
	private List <Particle> particles = new ArrayList<Particle>();
	
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
		int i;
		for (i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.update();
		}
		for (i = 0; i < particles.size(); i++) {
			Particle p = particles.get(i);
			p.update();
		}
		clear();
	}
	
	public void clear() {
		int i;
		for (i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved())
				entities.remove(i);
		}
		for (i = 0; i < particles.size(); i++) {
			if (particles.get(i).isRemoved())
				particles.remove(i);
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
		
		for (Entity e : entities) 
			e.render(screen);
		for (Particle p : particles) 
			p.render(screen);
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
		e.init(this);
		if (e instanceof Particle) {
			particles.add((Particle) e);
		} else {
			entities.add(e);
		}
	}
	
	public void remove(Entity e) {
		if (e instanceof Particle)
			particles.remove(e);
		else
			entities.remove(e);
	}
	
	/**
	 * Given an entity, will check if that entity is colliding with any other entities. If a collision is 
	 * detected, the didCollide method will be called on both entities.
	 * @param e
	 * @return true if one or more collisions were detected, otherwise false.
	 */
	public boolean checkCollisions(Entity e) {
		boolean didCollide = false;
		for (Entity other : entities) {
			if (e.isColliding(other)) {
				didCollide = true;
				e.didCollide(other);
				other.didCollide(e);
			}
		}
		return didCollide;
	}
	
	/* Private methods */
	
	
	protected void loadLevel(String path) {
		
	}

	protected void generateLevel() {
		
	}
	
	private void time () {
		
	}
	
}
