package com.piggy.mayhem.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
	public static SpriteSheet chars = new SpriteSheet("/textures/character_sprites.png", 512);
	public static SpriteSheet projectiles = new SpriteSheet("/textures/projectiles.png", 64);
	
	public static SpriteSheet player = new SpriteSheet("/textures/player.png", 64);
	public static SpriteSheet player_up = new SpriteSheet(player, 0, 0, 4, 1, 16);
	public static SpriteSheet player_down = new SpriteSheet(player, 0, 1, 4, 1, 16);
	public static SpriteSheet player_left = new SpriteSheet(player, 0, 2, 4, 1, 16);
	public static SpriteSheet player_right = new SpriteSheet(player, 0, 3, 4, 1, 16);
	
	private String path;
	public final int WIDTH, HEIGHT;
	public int [] pixels;
	private Sprite[] sprites;

	public SpriteSheet(String path, int size) {
		this.path   = path;
		this.HEIGHT = this.WIDTH = size;
		this.pixels = new int [size*size];
		load();
	}
	
	public SpriteSheet(String path, int width, int height) {
		this.path   = path;
		this.pixels = new int [width*height];
		this.HEIGHT = height;
		this.WIDTH  = width;
		load();
	}
	
	public SpriteSheet(SpriteSheet source, int x, int y, int width, int height, int spriteSize) {
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w =  width * spriteSize;
		int h = height * spriteSize;
		WIDTH = w;
		HEIGHT = h;
		pixels = new int [w * h];
		for (int y0 = 0; y0 < h; y0++) {
			int yPos = yy + y0;
			for (int x0 = 0; x0 < w; x0++) {
				int xPos = xx + x0;
				pixels[x0 + y0 * w] = source.pixels[xPos + yPos * source.WIDTH];
			}
		}
		int frame = 0;
		sprites = new Sprite [width * height];
		for (int ya = 0; ya < height; ya++) {
			for (int xa = 0; xa < width; xa++) {						// Iterate through every sprite
				int [] spritePixels = new int [spriteSize * spriteSize];
				for (int y0 = 0; y0 < spriteSize; y0++) {
					for (int x0 = 0; x0 < spriteSize; x0++) {			// Select every pixel in sprite
						spritePixels [x0 + y0 * spriteSize] = pixels[(x0 + xa * spriteSize)
						                                             + (y0 + ya * spriteSize) * WIDTH];
					}
				}
				Sprite sprite = new Sprite(spritePixels, spriteSize, spriteSize);
				sprites[frame++] = sprite; 
			}
		}
	}
	
	public Sprite[] getSprites() {
		return this.sprites;
	}	
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
