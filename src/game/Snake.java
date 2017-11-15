package game;

import mayflower.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Snake extends Actor {

    //Array of SnakeActors
    public List<SnakePart> snakeParts;

    public List<Integer> snakeLocationX;
    public List<Integer> snakeLocationY;

    public GameStage gameStage;

    //tells whether a copy just occurred for the snake.
    public boolean currentlyCopied = false;

    Snake(int x, int y, GameStage gameStage) {
        this.gameStage = gameStage;
        snakeParts = new ArrayList<>();
        snakeLocationX = new ArrayList<>();
        snakeLocationY = new ArrayList<>();
        snakeLocationX.add(x);
        snakeLocationY.add(y);
        SnakePart sn = new SnakePart(true, this);
        gameStage.addObject(sn, x, y);
        snakeParts.add(sn);
        currentlyCopied = false;
    }

    @Override
    public void act() {
        if (this.isTouching(Collectable.class)){
            increaseSnakeSize();
        }
    }

    public void increaseSnakeSize() {

        int copyX = snakeLocationX.get(snakeLocationX.size() - 1);
        int copyY = snakeLocationY.get(snakeLocationY.size() - 1);

        SnakePart sn = new SnakePart(false, this);
        gameStage.addObject(sn, copyX, copyY);
        snakeParts.add(sn);

        snakeLocationX.add(copyX);
        snakeLocationY.add(copyY);
        currentlyCopied = true;
    }

    //Given a direction (N, E, S, W), this method moves the snake depending on if another snake unit was added.
    public void move(String direction){

        //Condition for if the snake has just been copied.
        if(currentlyCopied){
            if(Objects.equals(direction, "N")) {
                snakeLocationY.set(snakeLocationY.size() - 1, snakeLocationY.get(snakeLocationY.size() - 1) - 20);
            }
            else if(Objects.equals(direction, "E")) {
                snakeLocationX.set(snakeLocationX.size() - 1, snakeLocationX.get(snakeLocationX.size() - 1) + 20);
            }
            else if(Objects.equals(direction, "S")) {
                snakeLocationY.set(snakeLocationY.size() - 1, snakeLocationY.get(snakeLocationY.size() - 1) + 20);
            }
            else if(Objects.equals(direction, "W")){
                snakeLocationX.set(snakeLocationX.size() - 1, snakeLocationX.get(snakeLocationX.size() - 1) - 20);
            }
            currentlyCopied = false;
        }

        //A regular move.
        else{
            if(Objects.equals(direction, "N")){
                snakeLocationY.set(snakeLocationY.size() - 1, snakeLocationY.get(snakeLocationY.size() - 1) - 20);
            }
            else if(Objects.equals(direction, "E")){
                snakeLocationX.set(snakeLocationX.size() - 1, snakeLocationX.get(snakeLocationX.size() - 1) + 20);
            }
            else if(Objects.equals(direction, "S")){
                snakeLocationY.set(snakeLocationY.size() - 1, snakeLocationY.get(snakeLocationY.size() - 1) + 20);
            }
            else if(Objects.equals(direction, "W")){
                snakeLocationX.set(snakeLocationX.size() - 1, snakeLocationX.get(snakeLocationX.size() - 1) - 20);
            }
        }

        //Uses the length of X because both arrays should be the same length.
        for(int i = 0; i < snakeLocationX.size() - 1; i++){
            //replaces every x value except the last with its superior.
            snakeLocationX.set(i, snakeLocationX.get(i+1));
            //replaces every y value except the last with its superior.
            snakeLocationY.set(i, snakeLocationY.get(i+1));
        }

        for (int i = 0; i < snakeParts.size(); i++) {
            snakeParts.get(i).move(snakeLocationX.get(i), snakeLocationY.get(i));
        }
    }


    public void addC(){
        gameStage.addCollectable();
    }
}
