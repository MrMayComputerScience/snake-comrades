package game;

import mayflower.*;

import java.util.List;

public class SnakePart extends Actor
{
    boolean isFront = false;

    public GameStage gameStage;
    public GameStageLocalMultiplayer gameStageL;

    public Snake snake;

    private boolean isSingle;
    private boolean isLocal;

    public SnakePart(boolean head, Snake a, boolean single, boolean local)
    {
        snake = a;

        if(single) {
            this.gameStage = (GameStage) getWorld();
        }
        else if(local){
            this.gameStageL = (GameStageLocalMultiplayer) getWorld();
        }

        setImage("img/snakePhoto"+ snake.skin +".png");
        isFront = head;

        isSingle = single;
        isLocal = local;

    }

    public void move(int x, int y) {
        setLocation(x,y);
    }

    @Override
    public void act()
    {
        //This if statement determines if this specific SnakePart is the head of the snake.
        if(isFront) {
            /*
             Checks if the head of the snake is touching a collectable, and if so,
             increases the snake size.
             */
            if (this.isTouching(Collectable.class)) {
                snake.increaseSnakeSize();
            }
        }

        if(isLocal) {
            if (this.getIntersectingObjects(SnakePart.class).size() > 1 && !snake.currentlyCopied) {
                this.gameStageL = (GameStageLocalMultiplayer) getWorld();
                Mayflower.setWorld(new GameOver(gameStageL.scoreBoard, gameStageL.keyCounter, gameStageL.skin, gameStageL.keep));
            }
            if (snake.isOne) {
                if (this.getIntersectingObjects(SnakePart.class).size() > 0 && !snake.currentlyCopied) {
                    this.gameStageL = (GameStageLocalMultiplayer) getWorld();
                    Mayflower.setWorld(new GameOver(gameStageL.scoreBoard, gameStageL.keyCounter, gameStageL.skin, gameStageL.keep));
                }
            }
        }
        if(isSingle) {
            if (this.getIntersectingObjects(SnakePart.class).size() > 1 && !snake.currentlyCopied) {
                this.gameStage = (GameStage) getWorld();
                Mayflower.setWorld(new GameOver(gameStage.scoreBoard, gameStage.keyCounter, gameStage.skin, gameStage.keep));
            }
            if (snake.isOne) {
                if (this.getIntersectingObjects(SnakePart.class).size() > 0 && !snake.currentlyCopied) {
                    this.gameStage = (GameStage) getWorld();
                    Mayflower.setWorld(new GameOver(gameStage.scoreBoard, gameStage.keyCounter, gameStage.skin, gameStage.keep));
                }
            }
        }

    }

}

