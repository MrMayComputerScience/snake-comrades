package game;

import mayflower.Actor;
import mayflower.Mayflower;

public class Wall extends Actor
{
    public GameStage gameStage;
    public GameStageLocalMultiplayer localMultGameStage;

    public Wall() {

        setImage("img/wall.jpg");

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
                Mayflower.setWorld(new GameOver(gameStage.scoreBoard, gameStage.keyCounter, gameStage.skin, gameStage.keep));
            }
            else if(Main.gameMode == GameMode.LOCAL_MULTIPLAYER){
                this.localMultGameStage = (GameStageLocalMultiplayer) getWorld();
                Mayflower.setWorld(new GameOver(localMultGameStage.scoreBoard, localMultGameStage.keyCounter, localMultGameStage.skin, localMultGameStage.keep));

            }

        }
    }
}

