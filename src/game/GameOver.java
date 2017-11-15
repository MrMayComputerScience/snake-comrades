package game;

import mayflower.World;
import mayflower.test.StringActor;

public class GameOver extends World {

    public GameOver(ScoreBoard scoreBoard, KeyCounter k) {

        setBackground("img/death.jpg");
        addObject(new StringActor("You scored " + scoreBoard.getScore() + " points!"), 400, 300);
        addObject(new StringActor("Click anywhere to continue."), 200, 500);
    }

    @Override
    public void act() {

    }
}
