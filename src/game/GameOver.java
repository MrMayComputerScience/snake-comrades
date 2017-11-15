package game;
import mayflower.*;
import mayflower.Mayflower;
import mayflower.World;
import mayflower.test.StringActor;

public class GameOver extends World {
    private ScoreBoard s;
    private KeyCounter k;
    private StringActor l;

    public GameOver(ScoreBoard scoreBoard, KeyCounter j) {

        setBackground("img/death.jpg");
        l = new StringActor("You have " + scoreBoard.getScore() + " points!");
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
            StartMenu nextWorld = new StartMenu(s,k);
            Mayflower.setWorld(nextWorld);
        }
    }
}
