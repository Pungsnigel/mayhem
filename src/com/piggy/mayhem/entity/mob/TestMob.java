package com.piggy.mayhem.entity.mob;

import com.piggy.mayhem.entity.Entity;
import com.piggy.mayhem.entity.projectile.Projectile;
import com.piggy.mayhem.graphics.AnimatedSprite;
import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.graphics.SpriteSheet;

public class TestMob extends Mob {
	
	private int dx = 1;
	private int dy = 1;

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
	public void didCollide(Entity other){
		if (other instanceof Projectile) {
			dx *= -1;
			dy *= -1;
		}
	}

	@Override
	public void update() {
		move(dx, dy);
		
		if (dir == Direction.DOWN)  animator = down;
		if (dir == Direction.UP)    animator = up;
		if (dir == Direction.LEFT)  animator = left;
		if (dir == Direction.RIGHT) animator = right;
		
		if (walking) animator.update();
		else 		 animator.setFrame(0);
		
	}

}
