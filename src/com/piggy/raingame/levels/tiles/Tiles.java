package com.piggy.raingame.levels.tiles;

import com.piggy.raingame.graphics.Sprite;
import com.piggy.raingame.levels.tiles.Tile.TileType;

public class Tiles {
	
	public static Tile grass = new GrassTile(Sprite.grass, TileType.walkable);
	public static Tile flowerGrass = new GrassTile(Sprite.flowerGrass, TileType.walkable);
	public static Tile trunk = new TrunkTile(Sprite.trunk, TileType.collidable);
	public static Tile bigTrunk = new BigTrunkTile(Sprite.BigTrunk, TileType.collidable);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite, TileType.unwalkable);
	public static Tile water    = new WaterTile(Sprite.water, TileType.unwalkable);
	public static Tile tiled_floor = new GrassTile(Sprite.tiled_floor, TileType.walkable);
	
	public static final int grassColor = 0xff35ff14;
	public static final int waterColor = 0xff145cff;
	public static final int trunkColor = 0xffff3014;
	public static final int flowerColor = 0xff348c31;
	
}
