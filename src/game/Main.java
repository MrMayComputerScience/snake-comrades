package game;

import mayflower.*;

public class Main extends Mayflower
{
    public static GameMode gameMode = null;
    public static Map map = null;


    private Main()
    {
        super("Snake 2D", 800, 600);
    }

    @Override
    public void init()
    {
        Mayflower.setFullScreen(false);
        World startingWorld = new StartMenu();
        Mayflower.setWorld(startingWorld);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}

