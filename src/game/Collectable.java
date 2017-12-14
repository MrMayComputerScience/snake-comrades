package game;


import mayflower.Actor;
import org.newdawn.slick.Game;

import java.util.List;
import java.util.Random;

public class Collectable extends Actor{

    public Snake snake;

    public Collectable(Snake a){
        snake = a;

        setImage("img/Collectable"+StartMenu.collectableSkin+".png");
    }

    @Override
    public void act() {
        if (this.isTouching(SnakePart.class)) {

            //Finds the snake from the SnakePart it just intersected.
            snake = this.getOneIntersectingObject(SnakePart.class).snake;

            //Use booleans to determine if I need to cast as a gamestage or localgmultiplayergamestage.
            if(Main.gameMode == GameMode.SINGLEPLAYER) {
                GameStage gag = (GameStage) this.getWorld();

                snake.increaseSnakeSize();
                gag.addCollectable();
                gag.scoreBoard.plusScore();
                gag.keep.plusScore();
                this.getWorld().removeObject(this);
            }
            else if(Main.gameMode == GameMode.LOCAL_MULTIPLAYER)
            {
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
