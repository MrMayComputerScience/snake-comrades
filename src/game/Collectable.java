package game;


import mayflower.Actor;

public class Collectable extends Actor{

    public GameStage gameStage;
    public Snake snake;

    public Collectable(Snake a){
        snake = a;
        setImage("img/shekle.png");
        this.gameStage= gameStage;

    }



    public void Contact(){

    }


    @Override
    public void act(){
        if (this.isTouching(SnakePart.class)) {
            snake.increaseSnakeSize();
            this.getWorld().removeObject(this);

        }
    }





}
