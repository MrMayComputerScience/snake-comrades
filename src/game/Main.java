package game;

import mayflower.*;

public class Main extends Mayflower
{

    private Main()
    {
        super("Snake", 800, 600);

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