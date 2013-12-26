package com.piggy.mayhem.graphics;

public class Sprite {
	
	public static Sprite grass = new Sprite(16, 16, 0, 0, SpriteSheet.tiles);
	public static Sprite flowerGrass = new Sprite (16, 16, 2, 0, SpriteSheet.tiles);
	public static Sprite trunk = new Sprite (16, 16, 1, 0, SpriteSheet.tiles);
	public static Sprite water = new Sprite (16, 16, 5, 0, SpriteSheet.tiles);
	public static Sprite BigTrunk = new Sprite (32, 48, 3, 0, SpriteSheet.tiles);
	public static Sprite tiled_floor = new Sprite (16, 16, 7, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 16, 0x1B87E0);
	
	public static Sprite player_down1 	= new Sprite(16, 16, 0, 31, SpriteSheet.chars);
	public static Sprite player_down2 	= new Sprite(16, 16, 1, 31, SpriteSheet.chars);
	public static Sprite player_down3 	= new Sprite(16, 16, 2, 31, SpriteSheet.chars);
	
	public static Sprite player_up1 	= new Sprite(16, 16, 0, 30, SpriteSheet.chars);
	public static Sprite player_up2 	= new Sprite(16, 16, 1, 30, SpriteSheet.chars);
	public static Sprite player_up3 	= new Sprite(16, 16, 2, 30, SpriteSheet.chars);
	
	public static Sprite player_left 	= new Sprite(16, 16, 0, 2, SpriteSheet.player);
	public static Sprite player_left1 	= new Sprite(16, 16, 1, 2, SpriteSheet.player);
	public static Sprite player_left2 	= new Sprite(16, 16, 2, 2, SpriteSheet.player);
	public static Sprite player_right 	= new Sprite(16, 16, 0, 3, SpriteSheet.player);
	public static Sprite player_right1 	= new Sprite(16, 16, 1, 3, SpriteSheet.player);
	public static Sprite player_right2 	= new Sprite(16, 16, 2, 3, SpriteSheet.player);
	
	public static Sprite proj_coffe    = new Sprite(16, 16, 0, 0, SpriteSheet.projectiles);
	
	public final int WIDTH, HEIGHT;
	private int x, y;
	public int [] pixels;
	protected SpriteSheet sheet;
	
	protected Sprite (int spriteWidth, int spriteHeight, SpriteSheet sheet) {
		this.WIDTH = spriteWidth;
		this.HEIGHT = spriteHeight;
		this.sheet = sheet;
		this.pixels = new int [WIDTH * HEIGHT];
	}
	
	public Sprite (int [] pixels, int width, int height) {
		this.WIDTH  = width;
		this.HEIGHT = height;
		this.pixels = pixels;
	}
	
	public Sprite (int width, int height, int x, int y, SpriteSheet sheet) {
		this.WIDTH = width;
		this.HEIGHT = height;
		pixels = new int [WIDTH * HEIGHT];
		this.x = x * 16;			// Define what coordinate in the spritesheet
		this.y = y * 16;
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
				pixels [x + y * WIDTH] = sheet.pixels[this.x + x + (y + this.y) * sheet.WIDTH];
			}
		}
	}
	
}
