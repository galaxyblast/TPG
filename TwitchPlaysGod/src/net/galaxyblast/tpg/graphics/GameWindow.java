package net.galaxyblast.tpg.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class GameWindow extends JFrame
{
	private Canvas canvas;
	
	public GameWindow()
	{
		super("Twitch Plays GOD");
		
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.canvas = new Canvas();
		
		this.add(canvas);
	}
}
