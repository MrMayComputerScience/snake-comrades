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
	private int keys;
	private int skin;

    public StartMenu()
    {
    	skin = 0;
    	score = 0;
    	keys = 0;
    	setBackground("img/titlescreen_minecraft.png");
		s = new ScoreBoard();
		k = new KeyCounter();
    	addObject(s, 50,50);
    	addObject(k,50,65);

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

    public StartMenu(ScoreBoard a, KeyCounter j,int i)
	{
		setBackground("img/titlescreen_minecraft.png");
		skin = i;
    	s = a;
    	k = j;
		score = a.getScore();
		keys = k.getScore();
    	addObject(s, 50,50);
    	addObject(k,50,65);

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

    @Override
    public void act()
    {
		if(Mayflower.mouseClicked(singleplayer)) {
			GameStage nextWorld = new GameStage(s,k,skin);
			Mayflower.setWorld(nextWorld);
		}

		if(Mayflower.mouseClicked(lootboxes)) {
			LootboxWorld nextWorld = new LootboxWorld(s,k,skin);
			Mayflower.setWorld(nextWorld);
		}

		if(Mayflower.mouseClicked(quit)) {
			Mayflower.exit();
		}
		if (Mayflower.isKeyPressed(Keyboard.KEY_GRAVE))
		{
			s.addKeyScore();
		}
    }
}