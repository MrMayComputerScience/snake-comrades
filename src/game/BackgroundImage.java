package game;
import mayflower.*;

import java.util.ArrayList;

public class BackgroundImage
{
    private int currentImage;
    private ArrayList<MayflowerImage> images;
    public BackgroundImage()
    {
        images= new ArrayList();
        for(int i = 0;i<79;i++)
        {
            images.add(new MayflowerImage("img/Background/frame_"+i+"_delay-0.04s.png"));
        }

    }
    public void nextImage(GameStage current)
    {
        current.setBackground(images.get(currentImage));
        if(currentImage==78)
            currentImage=0;
        else currentImage++;
    }
}
