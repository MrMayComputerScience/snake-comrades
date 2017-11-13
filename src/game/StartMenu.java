package game; /**
 * @(#)startMenu.java
 *
 *
 * @author 
 * @version 1.00 2017/5/1
 */

import mayflower.*;

public class StartMenu extends World
{
	private PlayButton p;
	private PlayButton b;
	private ScoreBoard s;
	private KeyCounter k;
	private int score;

    public StartMenu()
    {
    	score = 0;
    	setBackground("img/titlescreen_minecraft.png");
    	p = new PlayButton();
    	b = new PlayButton();
    	b.setImage("img/micro.png");
    	addObject(p, 333, 311);
    	addObject(b,90,311);
		s = new ScoreBoard();
    	addObject(s, 50,50);
    }

    public StartMenu(ScoreBoard a, KeyCounter j)
    {

    	setBackground("img/titlescreen_minecraft.png");
    	p = new PlayButton();
    	b = new PlayButton();
    	b.setImage("img/micro.png");
    	addObject(p, 333, 311);
		addObject(b,90,311);
    	s = a;
    	k=j;
		score = a.getScore();
    	addObject(s, 50,50);
    	addObject(k,50,65);
    }

    @Override
    public void act()
    {
    	if(Mayflower.mouseClicked(p))
    	{
    		GameStage nextWorld = new GameStage(s);
    		Mayflower.setWorld(nextWorld);
    	}
		if(Mayflower.mouseClicked(b))
		{
			LootboxWorld nextWorld = new LootboxWorld(s);
			Mayflower.setWorld(nextWorld);
		}
    }
}