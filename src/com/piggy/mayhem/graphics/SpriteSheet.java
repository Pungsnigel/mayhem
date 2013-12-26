package com.piggy.mayhem.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
	public static SpriteSheet chars = new SpriteSheet("/textures/character_sprites.png", 512);
	public static SpriteSheet projectiles = new SpriteSheet("/textures/projectiles.png", 64);
	
	public static SpriteSheet player = new SpriteSheet("/textures/player.png", 2);
	
	private String path;
	public final int WIDTH, HEIGHT;
	public int [] pixels;

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
