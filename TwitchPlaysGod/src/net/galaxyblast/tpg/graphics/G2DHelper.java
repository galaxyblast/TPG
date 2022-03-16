package net.galaxyblast.tpg.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;

import net.galaxyblast.tpg.Main;
import net.galaxyblast.tpg.util.Position;

public class G2DHelper
{
	private static Graphics2D G2D;
	public static final Position CAMERA_POSITION = new Position(0, 0);
	
	public static void setG2D(Graphics2D g)
	{
		G2D = g;
		G2D.translate(CAMERA_POSITION.getX(), CAMERA_POSITION.getY());
	}
	
	public static void setColor(Color c)
	{
		G2D.setColor(c);
	}
	
	public static void setColor(int r, int g, int b)
	{
		setColor(new Color(r, g, b));
	}
	
	public static void setColor(int r, int g, int b, int a)
	{
		setColor(new Color(r, g, b, a));
	}
	
	public static Color getColor()
	{
		return G2D.getColor();
	}
	
	public static void drawBackground(Color c)
	{
		setColor(c);
		G2D.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public static void drawBackground(int r, int g, int b)
	{
		drawBackground(new Color(r, g, b));
	}
	
	public static void drawBackground(int r, int g, int b, int a)
	{
		drawBackground(new Color(r, g, b, a));
	}
	
	public static void drawRect(int x, int y, int width, int height, float rotation)
	{
		G2D.translate(x, y);
		G2D.rotate(rotation);
		
		G2D.drawRect(0, 0, width, height);
		
		G2D.rotate(-rotation);
		G2D.translate(-x, -y);
	}
	
	public static void drawRect(int x, int y, int width, int height, float rotation, Color c)
	{
		Color lastColor = getColor();
		
		setColor(c);
		drawRect(x, y, width, height, rotation);
		setColor(lastColor);
	}
	
	public static void drawRect(int x, int y, int width, int height)
	{
		drawRect(x, y, width, height, 0);
	}
	
	public static void fillRect(int x, int y, int width, int height, float rotation)
	{
		G2D.translate(x, y);
		G2D.rotate(rotation);
		
		G2D.fillRect(0, 0, width, height);
		
		G2D.rotate(-rotation);
		G2D.translate(-x, -y);
	}
	
	public static void fillRect(int x, int y, int width, int height, float rotation, Color c)
	{
		Color lastColor = getColor();
		
		setColor(c);
		fillRect(x, y, width, height, rotation);
		setColor(lastColor);
	}
	
	public static void fillRect(int x, int y, int width, int height)
	{
		fillRect(x, y, width, height, 0);
	}
	
	public static void drawPolygon(int x, int y, Position[] vertices)
	{
		Polygon poly = new Polygon();
		for(Position pos : vertices)
		{
			poly.addPoint(pos.getX() + x, pos.getY() + y);
		}
		
		G2D.drawPolygon(poly);
	}
	
	public static void drawPolygon(int x, int y, Position[] vertices, float rotation)
	{
		G2D.translate(x, y);
		G2D.rotate(rotation);
		
		drawPolygon(0, 0, vertices);
		
		G2D.rotate(-rotation);
		G2D.translate(-x, -y);
	}
	
	public static void drawPolygon(int x, int y, Position[] vertices, float rotation, Color c)
	{
		Color lastColor = getColor();
		
		setColor(c);
		drawPolygon(x, y, vertices, rotation);
		setColor(lastColor);
	}
	
	public static void fillPolygon(int x, int y, Position[] vertices)
	{
		Polygon poly = new Polygon();
		for(Position pos : vertices)
		{
			poly.addPoint(pos.getX() + x, pos.getY() + y);
		}
		
		G2D.fillPolygon(poly);
	}
	
	public static void fillPolygon(int x, int y, Position[] vertices, float rotation)
	{
		G2D.translate(x, y);
		G2D.rotate(rotation);
		
		fillPolygon(0, 0, vertices);
		
		G2D.rotate(-rotation);
		G2D.translate(-x, -y);
	}
	
	public static void fillPolygon(int x, int y, Position[] vertices, float rotation, Color c)
	{
		Color lastColor = getColor();
		
		setColor(c);
		fillPolygon(x, y, vertices, rotation);
		setColor(lastColor);
	}
	
	public static void drawString(String str, Font font, int x, int y, Color c)
	{
		Color lastColor = getColor();
		
		setColor(c);
		G2D.setFont(font);
		G2D.drawString(str, x, y);
		setColor(lastColor);
	}
	
	public static void drawCenteredString(String str, Font font, int x, int y, Color c)
	{
		G2D.setFont(font);
		int w = G2D.getFontMetrics().stringWidth(str);
		int h = G2D.getFontMetrics().getHeight();
		
		drawString(str, font, x - (w / 2), y - (h / 2), c);
	}
	
	public static int getWidth()
	{
		return Main.getInstance().getWidth();
	}
	
	public static int getHeight()
	{
		return Main.getInstance().getHeight();
	}
}
