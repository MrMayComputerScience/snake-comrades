package game;

import mayflower.Actor;
import mayflower.Mayflower;

import java.util.List;

public class Wall extends Actor
{
    public GameStage gameStage;
    public GameStageLocalMultiplayer localMultGameStage;

    public boolean isSingle;
    public boolean isLocal;


    public Wall(boolean single, boolean local) {

        isSingle = single;
        isLocal = local;

        setImage("img/wall.jpg");
        if(isSingle) {
            this.gameStage = (GameStage) getWorld();
        }
        else if(isLocal){
            this.localMultGameStage = (GameStageLocalMultiplayer)getWorld();
        }

    }

    @Override
    public void act() {
        if(this.isTouching(SnakePart.class)) {

            if(isSingle) {
                this.gameStage = (GameStage) getWorld();
                Mayflower.setWorld(new GameOver(gameStage.scoreBoard, gameStage.keyCounter, gameStage.skin, gameStage.keep, 0));
            }
            else if(isLocal){
                this.localMultGameStage = (GameStageLocalMultiplayer) getWorld();
                localMultGameStage.removePlayer(this.getOneIntersectingObject(SnakePart.class).snake);


            }

        }
    }
}
