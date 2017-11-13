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
	private ScoreBoard s;
	private KeyCounter k;
	private LongMenuButton singleplayer, localMulti, netMulti;
	private ShortMenuButton lootboxes, quit;
	private int score;

    public StartMenu()
    {
    	score = 0;
    	setBackground("img/titlescreen_minecraft.png");
		s = new ScoreBoard();
    	addObject(s, 50,50);

    	singleplayer = new LongMenuButton();
    	localMulti = new LongMenuButton();
    	netMulti = new LongMenuButton();
    	lootboxes = new ShortMenuButton();
    	quit = new ShortMenuButton();

    	addObject(singleplayer, 233, 246);
    	addObject(localMulti, 233, 246+48);
    	addObject(netMulti, 233, 246+48*2);
    	addObject(lootboxes, 233, 414);
    	addObject(quit, 403, 414);
    }

    public StartMenu(ScoreBoard a, KeyCounter j)
    {


    	setBackground("img/titlescreen_minecraft.png");
    	s = a;
    	k=j;
		score = a.getScore();
    	addObject(s, 50,50);
    	addObject(k,50,65);
    }

    @Override
    public void act()
    {
		if(Mayflower.mouseClicked(singleplayer)) {
			GameStage nextWorld = new GameStage(s);
			Mayflower.setWorld(nextWorld);
		}

		if(Mayflower.mouseClicked(lootboxes)) {
			LootboxWorld nextWorld = new LootboxWorld(s);
			Mayflower.setWorld(nextWorld);
		}

		if(Mayflower.mouseClicked(quit)) {
			Mayflower.exit();
		}
    }
}