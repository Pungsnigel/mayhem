package com.piggy.mayhem.levels;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.piggy.mayhem.levels.tiles.Tile;

public class SpawnLevel extends Level{

	
	public SpawnLevel(String path) {
		super(path);
	}
	
	// Grass = 35ff14
	// Water = 145cff
	// Trunk = ff3014
	protected void generateLevel() {
		for (int i = 0; i < tiles.length; i++) {
		}
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int h = this.height = image.getHeight();
			int w = this.width  = image.getWidth();
			tiles = new int [w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Error loading spawnlevel");
		}
	}

}
