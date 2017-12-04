package game;
import mayflower.*;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

public class LootboxWorld  extends World
{
    private ScoreBoard s;
    private PlayButton p;
    private PlayButton b;
    private PlayButton l;
    private PlayButton oof;
    private PlayButton skins;
    private PlayButton paypal;
    private KeyCounter k;
    private CurrentSkin q;
    private int score;
    private int skin;
    private Random rand;




    public LootboxWorld(ScoreBoard a, KeyCounter j,int i)
    {
        setBackground("img/Background.jpg");
        skin=i;
        skins = new PlayButton();
        skins.setImage("img/snakePhoto"+skin+".png");
        p = new PlayButton();
        p.setImage("img/back.png");
        b = new PlayButton();
        b.setImage("img/buykey.png");
        oof = new PlayButton();
        oof.setImage("img/casescreen.png");
        l = new PlayButton();
        l.setImage("img/opencrate.png");
        addObject(p, 600, 400);
        s = a;
        score = s.getScore();
        addObject(s, 50,50);
        paypal = new PlayButton();
        paypal.setImage("img/paynow.png");
        addObject(paypal, -25, 400);
        k=j;
        q = new CurrentSkin();
        addObject(q,50,80);
        addObject(k, 50,65);
        addObject(oof,100,100);
        addObject(b,171,293);
        addObject(l,520,320);
        addObject(skins,150,84);

    }
    @Override
    public void act()
    {
        if(Mayflower.mouseClicked(p))
        {
            StartMenu nextWorld = new StartMenu(s,k,skin);
            Mayflower.setWorld(nextWorld);
        }
        else if(Mayflower.mouseClicked(paypal)) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.paypal.me/electronicartss"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(Mayflower.mouseClicked(l)&&k.getScore()>=1)
        {
            k.minusScore();
            rand = new Random();
            int p = rand.nextInt(100);
            if(p <15)
            {
                skin = 0;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
            else if(p<30)
            {
                skin = 1;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
            else if(p<45)
            {
                skin = 2;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
            else if(p<60)
            {
                skin = 3;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
            else if(p<75)
            {
                skin = 4;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
            else if(p<90)
            {
                skin = 5;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
            else if(p<92)
            {
                skin = 6;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
            else if(p<94)
            {
                skin = 7;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
            else if(p<96)
            {
                skin = 8;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
            else if(p<98)
            {
                skin = 9;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
            else
            {
                skin = 10;
                skins.setImage("img/snakePhoto"+skin+".png");
            }
        }
        else if(Mayflower.mouseClicked(b) && s.getScore()>=249)
        {
            k.plusScore();
            s.minusScore();
        }
    }
}
