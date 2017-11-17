package game;

import mayflower.*;

public class SnakePart extends Actor
{
    boolean isFront = false;

    public GameStage gameStage;
    public Snake snake;

    public SnakePart(boolean head, Snake a)
    {
        snake = a;
        this.gameStage = (GameStage) getWorld();
        setImage("img/snakePhoto"+ snake.skin +".png");
        isFront = head;

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

            if(this.getObjectsInRange(10, SnakePart.class).size() > 1 && !snake.currentlyCopied) {
                this.gameStage = (GameStage) getWorld();
                Mayflower.setWorld(new GameOver(gameStage.scoreBoard, gameStage.keyCounter,gameStage.skin));
            }
        }
    }

}

