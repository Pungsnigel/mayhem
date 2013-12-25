package com.piggy.mayhem.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.piggy.mayhem.entity.Entity;
import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.graphics.Sprite;

public class Particle extends Entity{
	private Sprite sprite;
	
	private int ticks;
	protected double xx,yy,xa, ya;
	
	private List<Particle> particles = new ArrayList<Particle>();
	
	public Particle (int x, int y, int ticks) {
		sprite = new Sprite(2,2, 0xFF00FF);
		this.x = x;
		this.y = y;
		this.xx = x; 			// Need double precision in calculations
		this.yy = y;
		this.ticks = ticks;
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
				
	}
	
	public Particle (int x, int y, int ticks, int amount ) {
		this(x, y, ticks);
		for (int i = 0; i < amount - 1; i++) {
			particles.add(new Particle(x, y, ticks));
		}
		particles.add(this);
	}
	
	public void update () {
		this.xx += this.xa;
		this.yy += this.ya;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy, sprite, true);
	}
	
	@Override
	public void didCollide(Entity e) {
	}

}
