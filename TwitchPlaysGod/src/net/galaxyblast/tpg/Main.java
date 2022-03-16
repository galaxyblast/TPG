package net.galaxyblast.tpg;

public class Main
{
	private static Game _instance;

	public static void main(String[] args)
	{
		_instance = new Game();
		_instance.start();
	}
	
	public static Game getInstance()
	{
		return _instance;
	}
}
