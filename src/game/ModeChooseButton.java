package game;

import mayflower.*;

public class ModeChooseButton extends Actor {

    private int index = 0;

    public ModeChooseButton()
    {
        setImage("img/button.png");

        if(Main.gameMode == null)
            setGamemode(0);
        else
            setGamemode(Main.gameMode);
    }

    public void setGamemode(int i) {
        if(i > GameMode.values().length - 1) i = 0;
        if(i < 0) i = GameMode.values().length - 1;

        index = i;

        setGamemode(GameMode.values()[i]);
    }

    private void setGamemode(GameMode mode) {
        Main.gameMode = mode;
        if(!Main.gameMode.isMulti()) Main.players = 1;

        setImage(new MayflowerImage("Mode - " + Main.gameMode.getText(), 24, new Color(255,255,255)));
    }

    @Override
    public void act() {
        if(Mayflower.isKeyPressed(Keyboard.KEY_UP)) {
            setGamemode(index-1);
        } else if(Mayflower.isKeyPressed(Keyboard.KEY_DOWN)) {
            setGamemode(index+1);
        }
    }
}
