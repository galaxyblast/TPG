package net.galaxyblast.tpg.world;

import java.awt.Color;
import java.util.ArrayList;

public class TileType
{
	private String name;
	private Color color;
	private float travelDifficulty; // 0 - 1
	private float maxElevation; // 0 - 1
	
	private static ArrayList<TileType> TILE_TYPES = new ArrayList<TileType>();
	
	public TileType(String name, Color c, float travelDif, float maxElev)
	{
		this.name = name;
		this.color = c;
		this.travelDifficulty = travelDif;
		this.maxElevation = maxElev;
		
		TILE_TYPES.add(this);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public float getTravelDifficulty()
	{
		return this.travelDifficulty;
	}
	
	public float getHeight()
	{
		return this.maxElevation;
	}
	
	public static TileType getTypeFromHeight(float height)
	{
		TileType typeOut = DEEP_OCEAN;
		
		for(TileType type : TILE_TYPES)
		{
			if(type.getHeight() <= height && type.getHeight() > typeOut.getHeight())
				typeOut = type;
		}

		return typeOut;
	}
	
	public static final TileType DEEP_OCEAN = new TileType("deep_ocean", new Color(0, 0, 200), 0.7F, 0.0F);
	public static final TileType OCEAN = new TileType("ocean", Color.blue, 0.5F, 0.001F);
	public static final TileType SEA = new TileType("sea", new Color(64, 64, 255), 0.4F, 0.3F);
	public static final TileType BEACH = new TileType("beach", new Color(194, 178, 128), 0.15F, 0.4F);
	public static final TileType GRASS = new TileType("grass", new Color(0, 200, 64), 0.1F, 0.5F);
	public static final TileType FOREST = new TileType("forest", new Color(0, 128, 32), 0.3F, 0.7F);
	public static final TileType MOUNTAIN = new TileType("hill", new Color(64, 64, 64), 0.6F, 0.9F);
}
