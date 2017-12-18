package game;
import mayflower.*;

import java.awt.*;
import java.net.URI;
import java.util.Random;

public class LootboxWorld  extends World
{
    private ScoreBoard s;
    private PlayButton p;
    private PlayButton b;
    private PlayButton l;
    private PlayButton skins;
    private PlayButton paypal;
    private KeyCounter k;
    private int skin;
    private PlayButton musicCrate;
    private PlayButton collectableB;
    private PlayButton currentCl;



    public LootboxWorld()
    {
        setBackground("img/Background.jpg");
        skin= Main.snakeSkin;
        skins = new PlayButton();
        skins.setImage("img/snakePhoto"+skin+".png");
        p = new PlayButton();
        p.setImage("img/back.png");
        b = new PlayButton();
        b.setImage("img/buykey.png");
        PlayButton oof = new PlayButton();
        oof.setImage("img/casescreen.png");
        l = new PlayButton();
        l.setImage("img/opencrate.png");
        collectableB = new PlayButton();
        collectableB.setImage("img/opencrate.png");
        musicCrate = new PlayButton();
        musicCrate.setImage("img/opencrate.png");
        currentCl = new PlayButton();
        currentCl.setImage("img/Collectable"+Main.collectableSkin+".png");
        CollectableDisplay currentC = new CollectableDisplay();
        addObject(p, 600, 400);
        s = Main.scoreBoard;
        int score = s.getScore();
        addObject(s, 50,50);
        paypal = new PlayButton();
        paypal.setImage("img/paynow.png");
        addObject(paypal, -25, 400);
        k= Main.keyCounter;
        CurrentSkin q = new CurrentSkin();

        addObject(q,50,80);
        addObject(k, 50,65);
        addObject(oof,100,100);
        addObject(b,171,293);
        addObject(l,520,320);
        addObject(skins,150,84);
        addObject(currentC,175,80);
        addObject(currentCl,320,84);
        addObject(musicCrate,520,351);
        addObject(collectableB,520,382);

    }
    @Override
    public void act()
    {
        Random rand;
        if(Mayflower.mouseClicked(p))
        {
            StartMenu nextWorld = new StartMenu();
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
            Main.snakeSkin = skin;
        }
        else if(Mayflower.mouseClicked(musicCrate) && k.getScore()>=1)
        {
            k.minusScore();
            rand = new Random();
            int p = rand.nextInt(160);
            System.out.println(p);
            if(p<10)
            {
                StartMenu.music = "jazz";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<20)
            {
                StartMenu.music = "Oasis";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<30)
            {
                StartMenu.music = "AmericanPie";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<40)
            {
                StartMenu.music = "RickRoll";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<50)
            {
                StartMenu.music = "Kalinka";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<60)
            {
                StartMenu.music = "CheekiBreeki";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<70)
            {
                StartMenu.music = "DangerBassBoost";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<80)
            {
                StartMenu.music = "HeyBassBoost";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<90)
            {
                StartMenu.music = "ChaChaSlideBassBoost";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<100)
            {
                StartMenu.music = "MansNotHotBassBoosted";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<110)
            {
                StartMenu.music = "OceanMan";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<=120)
            {
                StartMenu.music = "MansNotHot";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<=130)
            {
                StartMenu.music = "Rasputin";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<=140)
            {
                StartMenu.music = "GetLow";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<=150)
            {
                StartMenu.music = "TheDistance";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
            else if(p<=160)
            {
                StartMenu.music = "Yeah";
                StartMenu.currentSong.stop();
                StartMenu.currentSong = new MayflowerMusic("audio/"+ StartMenu.music +".wav");
                StartMenu.currentSong.play();
                StartMenu.currentSong.setVolume(1);
                System.out.println(StartMenu.music);
            }
        }
        else if(Mayflower.mouseClicked(collectableB)&&k.getScore()>=1)
        {
            k.minusScore();
            rand = new Random();
            int p = rand.nextInt(100);
            if(p <10)
            {
                Main.collectableSkin = 0;
                currentCl.setImage("img/Collectable"+Main.collectableSkin+".png");
            }
            else if(p<20)
            {
                Main.collectableSkin = 1;
                currentCl.setImage("img/Collectable"+Main.collectableSkin+".png");
            }
            else if(p<30)
            {
                Main.collectableSkin = 2;
                currentCl.setImage("img/Collectable"+Main.collectableSkin+".png");
            }
            else if(p<40)
            {
                Main.collectableSkin = 3;
                currentCl.setImage("img/Collectable"+Main.collectableSkin+".png");
            }
        }
        else if(Mayflower.mouseClicked(b) && s.getScore()>=249)
        {
            k.plusScore();
            s.minusKeyScore();
        }
    }
}
