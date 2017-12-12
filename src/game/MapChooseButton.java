package game;

import mayflower.*;

public class MapChooseButton extends Actor {

    private int index = 0;

    public MapChooseButton()
    {
        try {
            MapReader.initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setImage("img/button.png");
        setMap(0);
    }

    private void setMap(int i) {
        if(i > MapReader.maps.size() - 1) i = 0;
        if(i < 0) i = MapReader.maps.size() - 1;

        index = i;

        Main.map = MapReader.maps.get(index);

        setImage(new MayflowerImage("Map - " + Main.map.name, 24, new Color(255,255,255)));
    }

    @Override
    public void act() {
        if(Mayflower.isKeyPressed(Keyboard.KEY_LEFT)) {
            setMap(index-1);
        } else if(Mayflower.isKeyPressed(Keyboard.KEY_RIGHT)) {
            setMap(index+1);
        }
    }
}