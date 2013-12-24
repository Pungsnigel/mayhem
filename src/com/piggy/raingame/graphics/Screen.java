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
	
	public void renderTile(int xPos, int yPos, Sprite tile) {
		xPos -= xOffset;
		yPos -= yOffset;
		for (int y = 0; y < tile.HEIGHT; y++) {
			int ya = y + yPos;
			for (int x = 0; x < tile.WIDTH; x++) {
				int xa = x + xPos;
				if (xa < -tile.WIDTH || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya*width] = tile.pixels[x + y * tile.WIDTH];
			}
		}
	}
	
	public void renderPlayer(int xPos, int yPos, Sprite sprite, boolean xFlip, boolean yFlip) {
		xPos -= xOffset;
		yPos -= yOffset;
		for (int y = 0; y < sprite.HEIGHT; y++) {
			int ya = y + yPos;
			int yFlipped = yFlip ? (sprite.HEIGHT - 1) - y : y;
			for (int x = 0; x < sprite.WIDTH; x++) {
				int xa = x + xPos;
				int xFlipped = xFlip ? (sprite.WIDTH - 1) - x : x;
				if (xa < -height || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xFlipped + yFlipped * sprite.WIDTH];
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
