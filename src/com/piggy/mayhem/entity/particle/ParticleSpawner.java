package com.piggy.mayhem.entity.particle;

import java.awt.Color;

import com.piggy.mayhem.entity.spawner.Spawner;
import com.piggy.mayhem.levels.Level;

public class ParticleSpawner extends Spawner{
	
	private int life;
	private int color;
	
	public ParticleSpawner (int x, int y, int life, int amount) {
		this(x,y,life,amount, Color.GRAY.getRGB());
	}
	
	public ParticleSpawner (int x, int y, int life, int amount, int color) {
		super(x, y, Type.PARTICLE, amount);
		this.life = life;
		this.color = color;
	}
	
	public void init(Level level) {
		for (int i = 0; i < amount; i++) {
			level.add(new Particle(x, y, life + random.nextInt(20), color));
		}
	}

}
