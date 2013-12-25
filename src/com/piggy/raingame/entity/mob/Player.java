package com.piggy.raingame.entity.mob;


import com.piggy.raingame.Game;
import com.piggy.raingame.entity.Entity;
import com.piggy.raingame.entity.projectile.CoffeeCup;
import com.piggy.raingame.entity.projectile.Projectile;
import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.graphics.Sprite;
import com.piggy.raingame.input.KeyBoard;
import com.piggy.raingame.input.Mouse;

public class Player extends Mob {

	private KeyBoard input;
	private int animCount = 0;
	private double cooldown = 0;;
	
	public Player(KeyBoard input) {
		this(20, 20, input);
	}
	
	public Player(int x, int y, KeyBoard input) {
		super(x,y, 16, 8);
		this.input = input;
		this.sprite = Sprite.player_down1;
	}
	
		
	@Override
	public void update() {
		if (cooldown != 0) cooldown--;
		int dx = 0, dy = 0;
		if (input.up) 	 dy--;
		if (input.down)  dy++;
		if (input.left)  dx--;
		if (input.right) dx++;
		
		boolean walking = (dx != 0 || dy != 0);
		if (walking) {
			move(dx,dy);
			if (animCount < 1000) {
				animCount++;
			} else {
				animCount = 0;
			}
		}
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
		boolean xFlip = false, yFlip = false;
		if (dir == 0) {
			sprite = Sprite.player_up1;
			
			if (animCount % 40 > 10) {
				sprite = Sprite.player_up2;
				if (animCount % 40 > 20) {
					sprite = Sprite.player_up1;
					if (animCount % 40 > 30) {
						sprite = Sprite.player_up3;
						
					}
				}
			}
				
		}
		if (dir == 1) sprite = Sprite.player_down1;
		if (dir == 2) {
			sprite = Sprite.player_down1;
			
			if (animCount % 40 > 10) {
				sprite = Sprite.player_down2;
				if (animCount % 40 > 20) {
					sprite = Sprite.player_down1;
					if (animCount % 40 > 30) {
						sprite = Sprite.player_down3;
						
					}
				}
			}
				
		}
		if (dir == 3) sprite = Sprite.player_left;
		screen.renderEntity(x, y - this.sprite.HEIGHT / 2, this.sprite, xFlip, yFlip);
	}
	
	public void didCollide(Entity other){
		if (!(other instanceof Projectile)) {
			x = lastX;
			y = lastY;
		}
	}
	
}
