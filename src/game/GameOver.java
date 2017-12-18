package game;
import game.Stages.TickingStage;
import mayflower.Mayflower;
import mayflower.test.StringActor;

public class GameOver extends TickingStage {

    private StringActor l;

    public GameOver() {
        this(1); //Player 1 wins
    }

    public GameOver(int winner) {
        setBackground("img/winP" + winner + ".png");
        l = new StringActor("You got " + Main.currentRun.getScore() + " points!");
        addObject(l, 400, 300);
    }

    @Override
    public void act()
    {
        if(Mayflower.mouseClicked(l))
        {
            Main.currentRun = new CurrentRun();
            StartMenu nextWorld = new StartMenu();
            Mayflower.setWorld(nextWorld);
        }
    }
}
