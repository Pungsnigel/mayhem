package com.piggy.raingame.entity.projectile;

import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.graphics.Sprite;

public class CoffeeCup extends Projectile {
	
	public static final int FIRERATE = 15;

	public CoffeeCup(int x, int y, double dir) {
		super(x, y, dir);
		range = Projectile.rand.nextInt(60) + 30;
		speed = 3;
		dmg = 20;
		sprite = Sprite.proj_coffe;
		
		vecX = speed * Math.cos(angle);
		vecY = speed * Math.sin(angle);
		
	}

	public void update() {
		super.update();
		move();
	}
	
	protected void move() {
		this.x += vecX;
		this.y += vecY;

	}
	


	public void render(Screen screen) {
		screen.renderEntity((int)x - 8, (int)y - 16, sprite, false, false);
	}
	
}
