package game;
import mayflower.*;
public class LootboxWorld  extends World
{
    private ScoreBoard s;
    private PlayButton p;
    private PlayButton b;
    private PlayButton oof;
    private KeyCounter k;
    private int score;
    public LootboxWorld(ScoreBoard a)
    {
        setBackground("img/Background.jpg");
        p = new PlayButton();
        p.setImage("img/back.png");
        b = new PlayButton();
        b.setImage("img/buykey.png");
        oof = new PlayButton();
        oof.setImage("img/casescreen.png");
        addObject(p, 600, 400);
        s = a;
        score = s.getScore();
        addObject(s, 50,50);
        k = new KeyCounter();
        addObject(k, 50,65);
        addObject(oof,100,100);
        addObject(b,171,293);
    }
    @Override
    public void act()
    {
        if(Mayflower.mouseClicked(p))
        {
            StartMenu nextWorld = new StartMenu(s,k);
            Mayflower.setWorld(nextWorld);
        }
        if(Mayflower.mouseClicked(b) && k.getScore()>=249)
        {
            k.plusScore();
            s.minusScore();
        }
    }
}
