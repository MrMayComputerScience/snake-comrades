package game;


import mayflower.Actor;
import org.newdawn.slick.Game;

import java.util.Random;

public class Collectable extends Actor{

    public GameStage gameStage;
    public Snake snake;

    public Collectable(Snake a){
        snake = a;
        setImage("img/shekle.png");
        this.gameStage= gameStage;

    }






    @Override
    public void act(){
        if (this.isTouching(SnakePart.class)) {
            GameStage gag = (GameStage)this.getWorld();
            snake.increaseSnakeSize();
            gag.addCollectable();
            this.getWorld().removeObject(this);

        }
    }







}
