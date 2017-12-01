package game;


import mayflower.Actor;
import org.newdawn.slick.Game;

import java.util.Random;

public class Collectable extends Actor{

    public Snake snake;

    public Collectable(Snake a){
        snake = a;
        setImage("img/shekle.png");
    }

    @Override
    public void act() {
        if (this.isTouching(SnakePart.class)) {
            GameStage gag = (GameStage) this.getWorld();
            snake.increaseSnakeSize();
            gag.addCollectable();
            gag.scoreBoard.plusScore();
            gag.keep.plusScore();
            this.getWorld().removeObject(this);
        }
    }
}
