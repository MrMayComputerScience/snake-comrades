package game;

import mayflower.*;

public class SnakePart extends Actor
{
    boolean isFront = false;
    public SnakePart(boolean head)
    {
        setImage("img/snakePhoto.png");
        isFront = head;
    }

    public void move(int x, int y) {
        setLocation(x,y);
    }

    @Override
    public void act()
    {
        if(isFront) {
            if (this.isTouching(Collectable.class)) {

                //commented out so I can 
                //increaseSnakeSizeCall();
            }
        }
    }


    public void increaseSnakeSizeCall(){

    }
}

