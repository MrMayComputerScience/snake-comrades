package game;

import game.Stages.GameStage2;
import game.Stages.TickingStage;
import mayflower.Mayflower;

public class HowManyPlayersSelect extends TickingStage {
    private LongMenuButton twoPlayers;
    private LongMenuButton threePlayers;
    private LongMenuButton fourPlayers;


    public HowManyPlayersSelect(){
        setBackground("img/localMBackground.jpg");

        twoPlayers = new LongMenuButton();
        threePlayers = new LongMenuButton();
        fourPlayers = new LongMenuButton();

        addObject(twoPlayers,250,210);
        addObject(threePlayers, 250, 246+48);
        addObject(fourPlayers, 250, 370);
    }

    @Override
    public void act(){
        if(Mayflower.mouseClicked(twoPlayers)){
            Main.players = 2;

            GameStage2 gameStageL = new GameStage2();
            Mayflower.setWorld(gameStageL);
        } else if(Mayflower.mouseClicked(threePlayers)){
            Main.players = 3;

            GameStage2 gameStageL = new GameStage2();
            Mayflower.setWorld(gameStageL);
        } else if(Mayflower.mouseClicked(fourPlayers)){
            Main.players = 4;

            GameStage2 gameStageL = new GameStage2();
            Mayflower.setWorld(gameStageL);
        }
    }
}
