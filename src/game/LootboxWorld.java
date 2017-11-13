package game;
import mayflower.*;
public class LootboxWorld  extends World
{
    private ScoreBoard s;
    private PlayButton p;
    private PlayButton b;
    private int score;
    public LootboxWorld(ScoreBoard a)
    {
        setBackground("img/Background.jpg");
        p = new PlayButton();
        p.setImage("img/back.png");
        b = new PlayButton();
        b.setImage("");
        addObject(p, 600, 400);
        s = a;
        score = s.getScore();
        addObject(s, 50,50);
    }
    @Override
    public void act()
    {
        if(Mayflower.mouseClicked(p))
        {
            StartMenu nextWorld = new StartMenu(s);
            Mayflower.setWorld(nextWorld);
        }
    }
}
