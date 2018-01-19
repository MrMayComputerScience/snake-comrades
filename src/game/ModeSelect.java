package game;

import game.HowManyPlayersSelect;
import game.LongMenuButton;
import game.Main;
import game.ModeChooseButton;
import game.Stages.GameStage2;
import game.Stages.TickingStage;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.MayflowerMusic;
import org.newdawn.slick.Game;


public class ModeSelect extends TickingStage {

public LongMenuButton regular;
public LongMenuButton alwaysGrow;

public LongMenuButton snakeMouse;
public LongMenuButton twitchPlays;
//Allows for mode choosing.
public ModeChooseButton modeChooser;

public boolean single;
public boolean multi;

//Boolean representing if a mode has already been selected.
private boolean selected;

    public ModeSelect(Boolean sing, Boolean m){
        if(sing) {
            setBackground("img/1936OlympicsSingle.jpg");
        }
        else{
            setBackground("img/1936Olympics.jpg");
        }
        single = sing;
        multi = m;

        regular = new LongMenuButton();

        alwaysGrow = new LongMenuButton();
        //Allows for changing modes.
        modeChooser = new ModeChooseButton();
        addObject(regular, 233, 146);
        addObject(alwaysGrow, 233, 246);
        if(multi) {
            System.out.println("Designated as multiplayer sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
            snakeMouse = new LongMenuButton();
            twitchPlays = new LongMenuButton();
            addObject(snakeMouse, 233, 346);
            addObject(twitchPlays, 233, 446);
        }
        selected = false;
    }

    @Override
    public void act()
    {
        //Regular
        if(!selected) {
            if (Mayflower.mouseClicked(regular)) {
                if (single) {
                    System.out.println("Changed Game Mode to single ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
                    modeChooser.setGamemode(0);
                    GameStage2 nextWorld = new GameStage2();
                    Mayflower.setWorld(nextWorld);
                } else {
                    System.out.println("else1 ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
                    modeChooser.setGamemode(1);
                    HowManyPlayersSelect a = new HowManyPlayersSelect();
                    Mayflower.setWorld(a);
                }
                selected = true;
            }
        }
        //Snake Mouse
        if(!selected && multi) {
            if (Mayflower.mouseClicked(snakeMouse)) {
                System.out.println("if2 ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
                selected = true;
                modeChooser.setGamemode(2);
                HowManyPlayersSelect a = new HowManyPlayersSelect();
                Mayflower.setWorld(a);
            }
        }
        //Always grow.
        if(!selected) {
            if (Mayflower.mouseClicked(alwaysGrow)) {
                if (single) {
                    System.out.println("Changed Game Mode to single always grow ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
                    modeChooser.setGamemode(4);
                    GameStage2 nextWorld = new GameStage2();
                    Mayflower.setWorld(nextWorld);
                } else {
                    System.out.println("else2 ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
                    modeChooser.setGamemode(5);
                    HowManyPlayersSelect a = new HowManyPlayersSelect();
                    Mayflower.setWorld(a);
                }
                selected = true;
            }
        }
        //Twitch Plays
        if(!selected && multi) {
            if (Mayflower.mouseClicked(twitchPlays)) {
                System.out.println("if3 ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
               selected = true;
                modeChooser.setGamemode(2);
                HowManyPlayersSelect a = new HowManyPlayersSelect();
                Mayflower.setWorld(a);
            }
        }
    }
}
