package net.galaxyblast.tpg.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import net.galaxyblast.tpg.Main;
import net.galaxyblast.tpg.world.Tile;
import net.galaxyblast.tpg.world.TileType;

public class Canvas extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		
		G2DHelper.setG2D((Graphics2D)g);
		
		this.draw();
	}
	
	private void draw()
	{
		G2DHelper.drawBackground(Color.black);
		if(Main.getInstance() != null && Main.getInstance().getWorld() != null)
			Main.getInstance().getWorld().draw();
	}
}
