package com.piggy.mayhem.entity.projectile;

import com.piggy.mayhem.entity.Entity;
import com.piggy.mayhem.entity.mob.Mob;
import com.piggy.mayhem.entity.spawner.Spawner;
import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.graphics.Sprite;

public class CoffeeCup extends Projectile {
	
	public static final int FIRERATE = 15;

	public CoffeeCup(int x, int y, double dir, Mob owner) {
		super(x, y, 12, 8, dir, owner);
		range = Projectile.rand.nextInt(60) + 80;
		speed = 2;
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
		if (collision())
			remove();
		this.level.checkCollisions(this);
	}
	
	public void remove() {
		super.remove();
		level.add(new Spawner((int)x, (int)y, Spawner.Type.PARTICLE, 30));
	}
	
	public void render(Screen screen) {
		screen.renderEntity((int)x - 8, (int)y - 16, sprite, false, false);
	}
	
	public void didCollide(Entity other){
		if (!(other instanceof Mob && other == this.owner || other instanceof Projectile)) {
			remove();
		}
	}
}
