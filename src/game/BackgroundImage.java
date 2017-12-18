package game;

import game.Stages.GameStage2;
import mayflower.MayflowerImage;

import java.util.ArrayList;

public class BackgroundImage
{
    private int currentImage;
    private ArrayList<MayflowerImage> images;
    public BackgroundImage()
    {
        System.out.println("loop!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        images= new ArrayList();
        images.add(new MayflowerImage("img/black.png"));
        for(int i = 0;i<79;i++)
        {
            images.add(new MayflowerImage("img/Background/frame_"+i+"_delay-0.04s.png"));
        }
    }

    public void nextImage(GameStage2 current)
    {
        current.setBackground(images.get(currentImage));
        if(currentImage==images.size()-1)
            currentImage=0;
        else currentImage++;
    }
}
