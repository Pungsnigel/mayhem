package com.piggy.mayhem.entity.mob;

import com.piggy.mayhem.Game;
import com.piggy.mayhem.entity.Entity;
import com.piggy.mayhem.entity.projectile.CoffeeCup;
import com.piggy.mayhem.entity.projectile.Projectile;
import com.piggy.mayhem.graphics.AnimatedSprite;
import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.graphics.Sprite;
import com.piggy.mayhem.graphics.SpriteSheet;
import com.piggy.mayhem.input.KeyBoard;
import com.piggy.mayhem.input.Mouse;

public class Player extends Mob {

	private KeyBoard input;
	private double cooldown = 0;
	private boolean walking;
	
	private AnimatedSprite down = new AnimatedSprite(16, 16, SpriteSheet.player_down, 3);
	private AnimatedSprite up = new AnimatedSprite(16, 16, SpriteSheet.player_up, 3);
	private AnimatedSprite left= new AnimatedSprite(16, 16, SpriteSheet.player_left, 3);
	private AnimatedSprite right = new AnimatedSprite(16, 16, SpriteSheet.player_right, 3);
	
	private AnimatedSprite currentAnimation;
	
	public Player(KeyBoard input) {
		this(20, 20, input);
	}
	
	public Player(int x, int y, KeyBoard input) {
		super(x,y, 16, 8);
		this.input = input;
		this.sprite = Sprite.player_down1;
		currentAnimation = down;
	}
	
	@Override
	public void update() {
		if (walking) {
			currentAnimation.update();
		}else {
			currentAnimation.setFrame(0);
		}
		
		if (cooldown != 0) cooldown--;
		int dx = 0, dy = 0;
		if (input.up) {
			dy--;
			currentAnimation = up;
		}else if (input.down) {
			dy++;
			currentAnimation = down;
		}
		if (input.left) {
			dx--;
			currentAnimation = left;
		}
		if (input.right) {
			dx++;
			currentAnimation = right;
		}
		
		walking = (dx != 0 || dy != 0);
		if (walking) 
			move(dx,dy);
		if (Mouse.getB() == 1 && cooldown <= 0) 
			calcAndFireProj();
	}
	
	private void calcAndFireProj() {
		int midX = Game.getWindowWidth() / 2;
		int midY = Game.getWindowHeight() / 2;
		double dx = Mouse.getX() - midX;
		double dy = Mouse.getY() - midY;
		double dir = Math.atan2(dy, dx);
		shoot(x, y, dir);
		cooldown = CoffeeCup.FIRERATE;
	}

	public void render(Screen screen) {
		this.sprite = currentAnimation.getSprite();
		screen.renderEntity(x, y - this.sprite.HEIGHT / 2, this.sprite, false, false);
	}
	
	public void didCollide(Entity other){
		if (!(other instanceof Projectile)) {
			x = lastX;
			y = lastY;
		}
	}
	
}
