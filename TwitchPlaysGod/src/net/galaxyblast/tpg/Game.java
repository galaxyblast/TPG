package net.galaxyblast.tpg;

import java.util.Random;

import net.galaxyblast.tpg.graphics.GameWindow;
import net.galaxyblast.tpg.world.World;

public class Game
{
	private GameWindow window;
	private boolean isRunning = false;
	private int lastFps = 0;
	public final Random rng;
	
	private static final int _WORLD_SIZE = 121;
	private World world;
	
	public Game()
	{
		this.window = new GameWindow();
		this.rng = new Random(0L);
	}
	
	public void start()
	{
		this.world = new World(_WORLD_SIZE, _WORLD_SIZE);
		if(!this.isRunning)
		{
			this.isRunning = true;
			this.loop();
		}
	}
	
	private void loop()
	{
		long lastTime = System.currentTimeMillis();
		long lastFPSTime = System.currentTimeMillis();
		final int TARGET_FPS = 60;
		final int STEP_TIME = 1000 / TARGET_FPS;
		int frames = 0;
		
		while(this.isRunning)
		{
			this.checkInput();
			
			if(System.currentTimeMillis() - lastTime >= STEP_TIME)
			{
				this.tick();
				lastTime = System.currentTimeMillis();
				frames++;
			}
			
			if(System.currentTimeMillis() - lastFPSTime >= 1000)
			{
				this.lastFps = frames;
				frames = 0;
				lastFPSTime = System.currentTimeMillis();
			}
			
			this.render();
		}
	}
	
	private void checkInput()
	{
		
	}
	
	private void tick()
	{
		this.world.tick();
	}
	
	private void render()
	{
		this.window.repaint();
	}
	
	public int getLastFPS()
	{
		return this.lastFps;
	}
	
	public int getWidth()
	{
		return this.window.getWidth();
	}
	
	public int getHeight()
	{
		return this.window.getHeight();
	}
	
	public World getWorld()
	{
		return this.world;
	}
}
