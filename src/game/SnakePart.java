package game;

import mayflower.*;

public class SnakePart extends Actor
{
    public SnakePart()
    {
        setImage("img/snakePhoto.png");
    }

    public void move(int x, int y) {
        setLocation(x,y);
    }

    @Override
    public void act()
    {

    }
}

