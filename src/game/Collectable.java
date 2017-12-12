package game;


import mayflower.Actor;
import org.newdawn.slick.Game;

import java.util.List;
import java.util.Random;

public class Collectable extends Actor{

    public Snake snake;


    private boolean isSingle;
    private boolean isLocal;

    public Collectable(Snake a, boolean single, boolean local){
        snake = a;
        setImage("img/Collectable"+StartMenu.collectableSkin+".png");

        isSingle = single;
        isLocal = local;

    }

    @Override
    public void act() {
        if (this.isTouching(SnakePart.class)) {

            //Finds the snake from the SnakePart it just intersected.
            snake = this.getOneIntersectingObject(SnakePart.class).snake;

//Use booleans to determine if I need to cast as a gamestage or localgmultiplayergamestage.

            if(isSingle) {
                GameStage gag = (GameStage) this.getWorld();


                snake.increaseSnakeSize();
                gag.addCollectable();
                gag.scoreBoard.plusScore();
                gag.keep.plusScore();
                this.getWorld().removeObject(this);

            }
            else if(isLocal){
                GameStageLocalMultiplayer gagLocal = (GameStageLocalMultiplayer) this.getWorld();


                snake.increaseSnakeSize();
                gagLocal.addCollectable();
                gagLocal.scoreBoard.plusScore();
                gagLocal.keep.plusScore();
                this.getWorld().removeObject(this);
            }

        }
    }
}
