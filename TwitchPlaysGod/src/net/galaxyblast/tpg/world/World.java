package net.galaxyblast.tpg.world;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import net.galaxyblast.tpg.Main;
import net.galaxyblast.tpg.entities.People;
import net.galaxyblast.tpg.graphics.G2DHelper;
import net.galaxyblast.tpg.util.OpenSimplexNoise;
import net.galaxyblast.tpg.util.Utils;

public class World
{
	private Tile[][] map;
	private int year;
	private ArrayList<People> civs = new ArrayList<People>();
	
	private float prog = 0F;
	private long lastTime;
	
	public World(int xSize, int ySize)
	{
		this.map = new Tile[xSize][ySize];
		this.year = 0;
		
		this.initWorld(xSize, ySize);
	}
	
	private void initWorld(int xSize, int ySize)
	{
		OpenSimplexNoise noise = new OpenSimplexNoise(0);
		float scale = 20F;
		
		for(int y = 0; y < ySize; y++)
		{
			for(int x = 0; x < xSize; x++)
			{
				this.map[x][y] = new Tile(TileType.getTypeFromHeight((float)noise.eval(x / scale, y / scale)), x, y);
			}
		}
		
		this.lastTime = System.currentTimeMillis();
		this.generateStartingCivs(Main.getInstance().rng);
	}
	
	public void draw()
	{
		// Draw Map
		for(int y = 0; y < this.map.length; y++)
		{
			for(int x = 0; x < this.map[0].length; x++)
			{
				this.map[x][y].draw();
			}
		}
		
		// Draw progress background
		int padding = 25;
		int x = padding;
		int y = Main.getInstance().getHeight() - padding - 60;
		int w = Main.getInstance().getWidth() - (padding * 2) - 15;
		int w2 = (int)((float)w * this.prog);
		int h = 30;

		G2DHelper.fillRect(x, y, w, h, 0F, new Color(96, 96, 96));
		G2DHelper.fillRect(x, y, w2, h, 0F, new Color(200, 200, 200));
		
		// Draw Text
		G2DHelper.drawCenteredString("Year: " + year, new Font("Ariel", Font.PLAIN, 24), Main.getInstance().getWidth() / 2, y - 20, Color.white);
	}
	
	public void tick()
	{
		float seconds = 5F;
		long curTime = System.currentTimeMillis();
		this.prog = (float)(curTime - lastTime) / (1000F * seconds);
		
		if(this.prog >= 1F)
		{
			lastTime = curTime;
			this.year++;
		}
	}
	
	private void generateStartingCivs(Random rng)
	{
		int average = 10;
		int spread = 4;
		
		int numCivs = rng.nextInt(spread * 2) - spread + average;
		
		for(int i = 0; i < numCivs; i++)
		{
			People p = new People(Utils.randomColor(rng, 64, 198));
			p.giveTile(Utils.randomValidSpawn(rng, this.map));
		}
	}
}
