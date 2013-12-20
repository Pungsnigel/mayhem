package com.piggy.raingame.graphics;

public class Sprite {

	public final int WIDTH, HEIGHT;
	private int x, y;
	public int [] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 16, 0, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 16, 0x1B87E0);
	
	public static Sprite player_down 	= new Sprite(16, 32, 0, 4, SpriteSheet.tiles);
	public static Sprite player_up 		= new Sprite(16, 32, 4, 4, SpriteSheet.tiles);
	public static Sprite player_left 	= new Sprite(16, 32, 2, 4, SpriteSheet.tiles);
	public static Sprite player_right 	= new Sprite(16, 32, 6, 4, SpriteSheet.tiles);
	
	public Sprite (int width, int height, int x, int y, SpriteSheet sheet) {
		this.WIDTH = width;
		this.HEIGHT = height;
		pixels = new int [WIDTH * HEIGHT];
		this.x = x * WIDTH;			// Define what coordinate in the spritesheet
		this.y = y * HEIGHT;
		this.sheet = sheet;
		load();
	}

	public Sprite (int width, int height, int color) {
		WIDTH = width;
		HEIGHT = height;
		pixels = new int [WIDTH * HEIGHT];
		setColor(color);
	}
	
	private void setColor(int color) {
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			pixels[i] = color;
		}
	}
	
	/**
	 * Get the sprite from the spritesheet
	 */
	private void load() {
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				pixels [x + y * WIDTH] = sheet.pixels[this.x + x + (y + this.y) * sheet.SIZE];
			}
		}
	}
	
}
