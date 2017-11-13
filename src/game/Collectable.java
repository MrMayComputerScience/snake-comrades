package game;


import mayflower.Actor;

public class Collectable extends Actor{

    public GameStage gameStage;


    public Collectable(){
        setImage("img/shekle.png");
        this.gameStage= gameStage;

    }



    public void Contact(){

    }


    @Override
    public void act(){
        if (this.isTouching(SnakePart.class)) {
//            gameStage.removeObject(this);

        }
    }





}
