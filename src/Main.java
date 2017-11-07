import mayflower.*;
public class Main extends Mayflower
{
    //Construct a Mayflower Window.
    public Main()
    {
        super("Final Project", 800, 600);
    }
    @Override
    public void init()
    {
        Mayflower.setFullScreen(false);
        World startingWorld = new startMenu();
        Mayflower.setWorld(startingWorld);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}