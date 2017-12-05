package game;


import mayflower.Actor;
import org.newdawn.slick.Game;

import java.util.List;
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
            List intrsAct = this.getIntersectingObjects(this.getClass());

            //Trying to get the snake from each collectable it intersects.
            for(int i = 0; i < intrsAct.size(); i++){
                if(intrsAct.get(i) instanceof  SnakePart){
                    snake = ((SnakePart) intrsAct.get(i)).snake;
                }
            }
            //Need to set the snake variable to the snake the collectable is intersecting.




            GameStage gag = (GameStage) this.getWorld();
            snake.increaseSnakeSize();
            gag.addCollectable();
            gag.scoreBoard.plusScore();
            gag.keep.plusScore();
            this.getWorld().removeObject(this);



        }
    }
}
