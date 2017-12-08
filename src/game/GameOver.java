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

    private int playerNumb;


    public GameOver(ScoreBoard scoreBoard, KeyCounter j,int i,CurrentRun m, int pNumb) {

        playerNumb = pNumb;
        if(playerNumb == 1){
            setBackground("img/winP1.png");
        }
       else if(playerNumb ==2){
            setBackground("img/winP2.png");
        }
        else if(playerNumb ==3){
            setBackground("img/winP3.png");
        }
        else if(playerNumb ==4){
            setBackground("img/winP4.png");
        }
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
