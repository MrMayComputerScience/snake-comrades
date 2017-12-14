package game;

import mayflower.*;

import java.util.List;

public class SnakePart extends Actor
{
    boolean isFront = false;

    public GameStage gameStage;
    public GameStageLocalMultiplayer gameStageL;

    public Snake snake;

   public int playerNumb;

    public SnakePart(boolean head, Snake a, int pNumb)
    {
        snake = a;

        if(Main.gameMode == GameMode.SINGLEPLAYER) {
            this.gameStage = (GameStage) getWorld();
        }
        else if(Main.gameMode == GameMode.LOCAL_MULTIPLAYER){
            this.gameStageL = (GameStageLocalMultiplayer) getWorld();
        }

        setImage("img/snakePhoto"+ snake.skin +".png");
        isFront = head;

        playerNumb = pNumb;
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

        if(Main.gameMode == GameMode.SINGLEPLAYER) {
            if (this.getIntersectingObjects(SnakePart.class).size() > 1 && !snake.currentlyCopied) {
                this.gameStageL = (GameStageLocalMultiplayer) getWorld();
                Mayflower.setWorld(new GameOver(gameStageL.scoreBoard, gameStageL.keyCounter, gameStageL.skin, gameStageL.keep, playerNumb));
            }
            if (snake.isOne) {
                if (this.getIntersectingObjects(SnakePart.class).size() > 0 && !snake.currentlyCopied) {
                    ((GameStageLocalMultiplayer)this.getWorld()).removePlayer(snake);
                }
            }
        }
        if(Main.gameMode == GameMode.LOCAL_MULTIPLAYER) {
            if (this.getIntersectingObjects(SnakePart.class).size() > 1 && !snake.currentlyCopied) {
                this.gameStage = (GameStage) getWorld();
                Mayflower.setWorld(new GameOver(gameStage.scoreBoard, gameStage.keyCounter, gameStage.skin, gameStage.keep, playerNumb));
            }
            if (snake.isOne) {
                if (this.getIntersectingObjects(SnakePart.class).size() > 0 && !snake.currentlyCopied) {
                    this.gameStage = (GameStage) getWorld();
                    Mayflower.setWorld(new GameOver(gameStage.scoreBoard, gameStage.keyCounter, gameStage.skin, gameStage.keep, playerNumb));
                }
            }
        }

    }

}

