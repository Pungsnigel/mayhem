package com.piggy.raingame.entity.projectile;

import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.graphics.Sprite;

public class CoffeeCup extends Projectile {

	public CoffeeCup(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 2;
		dmg = 20;
		rateOfFire = 10;
		sprite = Sprite.proj_coffe;
		
		vecX = speed * Math.cos(angle);
		vecY = speed * Math.sin(angle);
		
	}

	public void update() {
		move();
	}
	
	protected void move() {
		x += vecX;
		y += vecY;
	}
	
	public void render(Screen screen) {
		screen.renderEntity(x, y, sprite);
	}
	
}
