package com.piggy.raingame.levels.tiles;

import com.piggy.raingame.graphics.Sprite;

public class Tiles {
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flowerGrass = new GrassTile(Sprite.flowerGrass);
	public static Tile trunk = new TrunkTile(Sprite.trunk);
	public static Tile bigTrunk = new BigTrunkTile(Sprite.BigTrunk);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile water    = new WaterTile(Sprite.water);
	
	public static final int grassColor = 0xff35ff14;
	public static final int waterColor = 0xff145cff;
	public static final int trunkColor = 0xffff3014;
	public static final int flowerColor = 0xff348c31;
	
}
