package com.piggy.raingame.graphics;

import java.util.Random;

import com.piggy.raingame.entity.mob.Player;
import com.piggy.raingame.levels.tiles.Tile;

public class Screen {
	
	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64; 
	public final int MAP_SIZE_MASK = 64 - 1;
	
	public int xOffset, yOffset;
	
	public int [] tiles = new int [MAP_SIZE * MAP_SIZE];
	
	private Random random = new Random();
	
	public Screen (int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int [width * height];
		
		for (int i = 0;i< MAP_SIZE*MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) 
			pixels[i] = 0;
	}
	
	public void renderTile(int xPos, int yPos, Tile tile) {
		xPos -= xOffset;
		yPos -= yOffset;
		for (int y = 0; y < tile.sprite.HEIGHT; y++) {
			int ya = y + yPos;
			for (int x = 0; x < tile.sprite.WIDTH; x++) {
				int xa = x + xPos;
				if (xa < -tile.sprite.WIDTH || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya*width] = tile.sprite.pixels[x + y * tile.sprite.WIDTH];
			}
		}
	}
	
	public void renderPlayer(int xPos, int yPos, Sprite sprite) {
		xPos -= xOffset;
		yPos -= yOffset;
		for (int y = 0; y < sprite.HEIGHT; y++) {
			int ya = y + yPos;
			for (int x = 0; x < sprite.WIDTH; x++) {
				int xa = x + xPos;
				if (xa < -16 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x + y * sprite.WIDTH];
				if (col != 0xFF8C11FF)
					pixels[xa + ya*width] = col;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
