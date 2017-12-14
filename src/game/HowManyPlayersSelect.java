package game;

import java.awt.*;
import mayflower.*;

public class HowManyPlayersSelect extends World {


    private ScoreBoard scoreboard;
    private KeyCounter keycounter;
    private int skin;
    private LongMenuButton twoPlayers;
    private LongMenuButton threePlayers;
    private LongMenuButton fourPlayers;


    public HowManyPlayersSelect(ScoreBoard s,KeyCounter k, int sn){

        setBackground("img/localMBackground.jpg");
        scoreboard = s;
        keycounter = k;
        skin = sn;

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
            GameStageLocalMultiplayer gameStageL = new GameStageLocalMultiplayer(scoreboard,keycounter,skin,2);
            Mayflower.setWorld(gameStageL);
        }
        if(Mayflower.mouseClicked(threePlayers)){
            GameStageLocalMultiplayer gameStageL = new GameStageLocalMultiplayer(scoreboard,keycounter,skin,3);
            Mayflower.setWorld(gameStageL);
        }
        if(Mayflower.mouseClicked(fourPlayers)){
            GameStageLocalMultiplayer gameStageL = new GameStageLocalMultiplayer(scoreboard,keycounter,skin,4);
            Mayflower.setWorld(gameStageL);
        }
    }




}
