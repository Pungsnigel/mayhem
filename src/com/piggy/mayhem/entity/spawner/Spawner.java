package com.piggy.mayhem.entity.spawner;

import java.util.ArrayList;
import java.util.List;

import com.piggy.mayhem.entity.Entity;

public class Spawner extends Entity{
	
	private List <Entity> entities = new ArrayList <Entity>();
	
	public enum Type {
		MOB, PARTICLE
	};

	private Type type;
	protected int amount;
	
	public Spawner(int x, int y, Type type, int amount) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.amount = amount;
	}
	
	@Override
	public void didCollide(Entity e) {
		
	}
	

}
