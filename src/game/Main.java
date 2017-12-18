package game;

import mayflower.*;

public class Main extends Mayflower
{
    public static GameMode gameMode = null;
    public static Map map = null;
    public static int players = 1;

    public static int snakeSkin = 0;
    public static int collectableSkin = 0;
    public static ScoreBoard scoreBoard;
    public static CurrentRun currentRun;
    public static KeyCounter keyCounter;

    private Main()
    {
        super("Snake 2D", 800, 600);
    }

    @Override
    public void init()
    {
        scoreBoard = new ScoreBoard();
        keyCounter = new KeyCounter();
        currentRun = new CurrentRun();

        Mayflower.setFullScreen(false);
        World startingWorld = new StartMenu();
        Mayflower.setWorld(startingWorld);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}

