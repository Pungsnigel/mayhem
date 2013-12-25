package com.piggy.mayhem.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.piggy.mayhem.entity.Entity;
import com.piggy.mayhem.graphics.Screen;
import com.piggy.mayhem.graphics.Sprite;

public class Particle extends Entity{
	private Sprite sprite;
	
	private int ticks;
	
	
	private List<Particle> particles = new ArrayList<Particle>();
	
	public Particle (int x, int y, int ticks) {
		sprite = new Sprite(2,2, 0xFF00FF);
		this.x = x;
		this.y = y;
		this.ticks = ticks;
		particles.add(this);
	}
	
	public Particle (int x, int y, int ticks, int amount ) {
		this(x, y, ticks);
		for (int i = 0; i < amount - 1; i++) {
			particles.add(new Particle(x, y, ticks));
		}
	}
	
	public void update () {
	}
	
	public void render(Screen screen) {
	}

	@Override
	public void didCollide(Entity e) {
	}

}
