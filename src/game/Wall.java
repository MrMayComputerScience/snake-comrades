package game;

import mayflower.Actor;
import mayflower.Mayflower;

public class Wall extends Actor
{
    public GameStage gameStage;

    public Wall() {
        setImage("img/wall.png");
        this.gameStage = (GameStage) getWorld();
    }

    @Override
    public void act() {
        if(this.isTouching(SnakePart.class)) {
            Mayflower.setWorld(new GameOver());
        }
    }
}
