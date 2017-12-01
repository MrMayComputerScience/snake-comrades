package game;

import mayflower.Actor;
import mayflower.Mayflower;

public class Wall extends Actor
{
    public GameStage gameStage;

    public Wall() {
        setImage("img/wall.jpg");
        this.gameStage = (GameStage) getWorld();
    }

    @Override
    public void act() {
        if(this.isTouching(SnakePart.class)) {
            this.gameStage = (GameStage) getWorld();
            Mayflower.setWorld(new GameOver(gameStage.scoreBoard, gameStage.keyCounter, gameStage.skin, gameStage.keep));
        }
    }
}
