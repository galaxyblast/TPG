package net.galaxyblast.tpg.util;

import java.awt.Color;
import java.util.Random;

import net.galaxyblast.tpg.world.Tile;
import net.galaxyblast.tpg.world.TileType;

public class Utils
{
	public static Color randomColor(Random rng, int minValue, int maxValue)
	{
		int range = maxValue - minValue;
		return new Color(rng.nextInt(range) + minValue, rng.nextInt(range) + minValue, rng.nextInt(range) + minValue);
	}
	
	public static Color randomColor(Random rng)
	{
		return randomColor(rng, 0, 255);
	}
	
	public static Tile randomValidSpawn(Random rng, Tile[][] map)
	{
		int maxX = map.length;
		int maxY = map[0].length;
		
		int attemptsLeft = 20;
		
		Tile tileOut = null;
		
		while(tileOut == null && attemptsLeft > 0)
		{
			Tile testTile = map[rng.nextInt(maxX)][rng.nextInt(maxY)];
			
			if(testTile.getOwner() == null && testTile.getType() != TileType.DEEP_OCEAN && testTile.getType() != TileType.OCEAN && testTile.getType() != TileType.SEA)
			{
				tileOut = testTile;
			}
			
			attemptsLeft--;
		}
		
		return tileOut;
	}
}
