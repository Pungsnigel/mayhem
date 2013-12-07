package com.piggy.raingame.graphics;

import java.util.Random;

public class Screen {
	
	private int width, height;
	public int[] pixels;
	
	public final int MAP_SIZE 		= 64; 
	public final int MAP_SIZE_MASK	= 64 - 1;
	
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
	
	public void render(int xOffset, int yOffset) {
		for (int y = 0; y < height; y++) {
			int yPix = (y + yOffset) ;
			if (yPix < 0 || yPix >= height) continue; 
			for (int x = 0; x < width; x++) {
				int xPix = x + xOffset;
				if (xPix < 0 || xPix >= width) continue;
				pixels[xPix + yPix * width] = Sprite.grass.pixels[(x&15) + (y&15) *Sprite.grass.SIZE];
			}
		}
	}
}
