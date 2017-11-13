package game;
import mayflower.*;
public class KeyCounter extends Actor
{
    private int keys;

    public KeyCounter()
    {
        keys = 0;
        setImage(new MayflowerImage("Keys: " + keys, 16, new Color(0,255,0)));
    }

    public void plusScore()
    {
        keys++;
        act();
    }

    public int getScore()
    {
        return keys;
    }

    @Override
    public void act()
    {
        setImage(new MayflowerImage("Keys: " + keys, 16, new Color(0,255,0)));
    }
}
