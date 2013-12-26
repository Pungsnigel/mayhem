package com.piggy.mayhem.graphics;

public class AnimatedSprite extends Sprite {
	
	private int frame = 0;
	private Sprite sprite;
	private int rate = 5; 			// Some average default value
	private int length = -1;
	private int time = 0; 
	
	public AnimatedSprite(int spriteWidth, int spriteHeight, SpriteSheet sheet, int animationLength) {
		super(spriteWidth,spriteHeight, sheet);
		this.length = animationLength;
		sprite = sheet.getSprites()[0];
	}
	
	public void update() {
		time++;
		if (time % rate == 0) {
			if (frame >= length-1) frame = 0;
			else 				   frame++;
			sprite = sheet.getSprites()[frame];
		}
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	public void setFrameRate(int rate) {
		this.rate = rate;
	}
	

}
