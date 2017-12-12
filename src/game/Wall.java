package game;

import mayflower.Actor;
import mayflower.Mayflower;

import java.util.List;

public class Wall extends Actor
{
    public GameStage gameStage;
    public GameStageLocalMultiplayer localMultGameStage;

    public Wall() {

        setImage("img/wall.png");

        if(Main.gameMode == GameMode.SINGLEPLAYER) {
            this.gameStage = (GameStage) getWorld();
        }
        else if(Main.gameMode == GameMode.LOCAL_MULTIPLAYER){
            this.localMultGameStage = (GameStageLocalMultiplayer)getWorld();
        }

    }

    @Override
    public void act() {
        if(this.isTouching(SnakePart.class)) {
            if(Main.gameMode == GameMode.SINGLEPLAYER) {
                this.gameStage = (GameStage) getWorld();
                Mayflower.setWorld(new GameOver(gameStage.scoreBoard, gameStage.keyCounter, gameStage.skin, gameStage.keep, 0));
            }
            else if(Main.gameMode == GameMode.LOCAL_MULTIPLAYER){
                this.localMultGameStage = (GameStageLocalMultiplayer) getWorld();
                localMultGameStage.removePlayer(this.getOneIntersectingObject(SnakePart.class).snake);


            }

        }
    }
}

