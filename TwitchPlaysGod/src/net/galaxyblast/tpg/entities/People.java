package net.galaxyblast.tpg.entities;

import java.awt.Color;
import java.util.ArrayList;

import net.galaxyblast.tpg.Main;
import net.galaxyblast.tpg.world.Tile;

public class People
{
	private ArrayList<Tile> territory = new ArrayList<Tile>();
	private int techLevel = 0;
	private float techProg = 0F;
	private int cultureLevel = 0;
	private float cultureProg = 0F;
	private int morale = 0;
	private float expandFactor;
	private float aggression;
	private Color color;
	
	public People(Color c)
	{
		this.color = c;
		this.expandFactor = Main.getInstance().rng.nextFloat();
		this.aggression = Main.getInstance().rng.nextFloat();
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public int getTechLevel()
	{
		return this.techLevel;
	}
	
	public void adjustTechLevel(float amt)
	{
		this.techProg += amt;
		if(this.techProg >= 1F)
		{
			this.techLevel++;
			this.techProg -= 1F;
		}
	}
	
	public int getCultureLevel()
	{
		return this.cultureLevel;
	}
	
	public void adjustCultureLevel(float amt)
	{
		this.cultureProg += amt;
		if(this.cultureProg >= 1F)
		{
			this.cultureLevel++;
			this.cultureProg -= 1F;
		}
	}
	
	public int getMorale()
	{
		return this.morale;
	}
	
	public void adjustMorale(int amt)
	{
		this.morale += amt;
	}
	
	public void tick()
	{
		
	}
	
	public void giveTile(Tile t)
	{
		this.territory.add(t);
		t.setOwner(this);
	}
	
	public void removeTile(Tile t)
	{
		if(this.territory.contains(t))
			this.territory.remove(t);
	}
}
