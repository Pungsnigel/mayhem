package com.piggy.raingame.entity.mob;

import com.piggy.raingame.graphics.Screen;
import com.piggy.raingame.graphics.Sprite;
import com.piggy.raingame.input.KeyBoard;

public class Player extends Mob {

	private KeyBoard input;
	private int animCount = 0;
	
	public Player(KeyBoard input) {
		this(300, 300, input);
	}
	
	public Player(int x, int y, KeyBoard input) {
		this.input = input;
		this.x = x;
		this.y = y;
		this.sprite = Sprite.player_down;
	}
	
	@Override
	public void update() {
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
			
	}
	
	public void render(Screen screen) {
		boolean xFlip = false, yFlip = false;
		if (dir == 0) sprite = Sprite.player_up;
		if (dir == 1) sprite = Sprite.player_right;
		if (dir == 2) {
			sprite = Sprite.player_down;
			if (animCount % 40 > 20) 
				xFlip = true;
		}
		if (dir == 3) sprite = Sprite.player_left;
		screen.renderPlayer(x, y - this.sprite.HEIGHT / 2, this.sprite, xFlip, yFlip);
	}
	
}
