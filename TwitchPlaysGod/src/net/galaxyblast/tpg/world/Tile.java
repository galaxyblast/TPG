package net.galaxyblast.tpg.world;

import java.awt.Color;

import net.galaxyblast.tpg.entities.People;
import net.galaxyblast.tpg.graphics.G2DHelper;
import net.galaxyblast.tpg.util.Position;

public class Tile
{
	private TileType type;
	public final Position position;
	private People owner;
	private int health;
	
	private static Position[] shape;
	private static final int _SHAPE_SIZE = 5;
	private static final float _SHAPE_OFFSET = (float)((float)_SHAPE_SIZE * Math.sin(2 * Math.PI / 6D));
	private static final float _ROTATION = (float)Math.toRadians(90D);
	
	public Tile(TileType type, int x, int y)
	{
		this.type = type;
		this.position = new Position(x, y);
	}
	
	public void draw()
	{
		if(this.position.getY() % 2 == 0)
		{
			G2DHelper.fillPolygon((this.position.getX() + 1) * (int)(_SHAPE_OFFSET * 2F), (this.position.getY() + 1) * (int)((float)_SHAPE_SIZE * 1.5F), getTileShape(), _ROTATION, this.type.getColor());
			//G2DHelper.drawPolygon((this.position.getX() + 1) * (int)(_SHAPE_OFFSET * 2F), (this.position.getY() + 1) * (int)((float)_SHAPE_SIZE * 1.5F), getTileShape(), _ROTATION, this.type.getColor().darker());
			
			if(this.owner != null)
			{
				Color c = new Color(this.owner.getColor().getRed(), this.owner.getColor().getGreen(), this.owner.getColor().getBlue(), 196);
				
				G2DHelper.fillPolygon((this.position.getX() + 1) * (int)(_SHAPE_OFFSET * 2F), (this.position.getY() + 1) * (int)((float)_SHAPE_SIZE * 1.5F), getTileShape(), _ROTATION, c);
			}
		}
		else
		{
			G2DHelper.fillPolygon((this.position.getX() + 1) * (int)(_SHAPE_OFFSET * 2F) + (int)_SHAPE_OFFSET, (this.position.getY() + 1) * (int)((float)_SHAPE_SIZE * 1.5F), getTileShape(), _ROTATION, this.type.getColor());
			//G2DHelper.drawPolygon((this.position.getX() + 1) * (int)(_SHAPE_OFFSET * 2F) + (int)_SHAPE_OFFSET, (this.position.getY() + 1) * (int)((float)_SHAPE_SIZE * 1.5F), getTileShape(), _ROTATION, this.type.getColor().darker());
			
			if(this.owner != null)
			{
				Color c = new Color(this.owner.getColor().getRed(), this.owner.getColor().getGreen(), this.owner.getColor().getBlue(), 196);
				
				G2DHelper.fillPolygon((this.position.getX() + 1) * (int)(_SHAPE_OFFSET * 2F) + (int)_SHAPE_OFFSET, (this.position.getY() + 1) * (int)((float)_SHAPE_SIZE * 1.5F), getTileShape(), _ROTATION, c);
			}
		}
	}
	
	public People getOwner()
	{
		return this.owner;
	}
	
	public void setOwner(People p)
	{
		if(this.owner != null)
			this.owner.removeTile(this);
		
		this.owner = p;
	}
	
	public TileType getType()
	{
		return this.type;
	}
	
	public static Position[] getTileShape()
	{
		if(shape == null)
		{
			shape = new Position[6];
			
			for(int i = 0; i < 6; i++)
			{
				shape[i] = new Position((int)(_SHAPE_SIZE * Math.cos(i * 2 * Math.PI / 6D)), (int)(_SHAPE_SIZE * Math.sin(i * 2 * Math.PI / 6D)));
			}
		}
		
		return shape;
	}
}
