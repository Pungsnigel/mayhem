package com.piggy.mayhem.entity.mob;

import com.piggy.mayhem.entity.Entity;
import com.piggy.mayhem.graphics.AnimatedSprite;
import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.graphics.SpriteSheet;

public class TestMob extends Mob {

	private AnimatedSprite animator;
	
	private AnimatedSprite down = new AnimatedSprite(16, 16, SpriteSheet.enemy_down, 4);
	private AnimatedSprite up = new AnimatedSprite(16, 16, SpriteSheet.enemy_up, 4);
	private AnimatedSprite left= new AnimatedSprite(16, 16, SpriteSheet.enemy_left, 4);
	private AnimatedSprite right = new AnimatedSprite(16, 16, SpriteSheet.enemy_right, 4);

	public TestMob(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x * 16;		// Set coordinate rather than pixel
		this.y = y * 16;		// Set coordinate rather than pixel
		this.width = width;
		this.height = height;
		this.animator = down;
	}

	@Override
	public void render(Screen screen) {
		this.sprite = animator.getSprite();
		screen.renderEntity(x, y, this.sprite, false, false);
	}

	@Override
	public void didCollide(Entity e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		this.animator.update();
		// TODO Auto-generated method stub
		
	}

}
