package game;
import mayflower.*;
import mayflower.Mayflower;
import mayflower.World;
import mayflower.test.StringActor;

public class GameOver extends World {
    private ScoreBoard s;
    private KeyCounter k;
    private StringActor l;
    private int skin;

    public GameOver(ScoreBoard scoreBoard, KeyCounter j,int i,CurrentRun m) {

        setBackground("img/death.jpg");
        skin = i;
        l = new StringActor("You got " + m.getScore() + " points!");
        addObject(l, 400, 300);
        s=scoreBoard;
        k=j;
        addObject(s,50,50);
        addObject(k,50,65);
    }

    @Override
    public void act()
    {
        if(Mayflower.mouseClicked(l))
        {
            StartMenu nextWorld = new StartMenu(s,k,skin);
            Mayflower.setWorld(nextWorld);
        }
    }
}
