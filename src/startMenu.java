/**
 * @(#)startMenu.java
 *
 *
 * @author 
 * @version 1.00 2017/5/1
 */

import mayflower.*;
public class startMenu extends World
{
private PlayButton p;
private ScoreBoard s;
private int score;
    public startMenu() 
    {
    	score = 0;
    	setBackground("img/Background.jpg");
    	p = new PlayButton();
    	addObject(p, 333, 311);
		s = new ScoreBoard();
    	addObject(s, 50,50);
    }
    public startMenu(ScoreBoard a)
    {
    	score = 0;
    	setBackground("img/Background.jpg");
    	p = new PlayButton();
    	addObject(p, 333, 311);
    	s = a;
    	addObject(s, 50,50);
    	
    		
    }
    @Override
    public void act()
    {
    	if(Mayflower.mouseClicked(p))
    	{
    		GameStage nextWorld = new GameStage(s);
    		Mayflower.setWorld(nextWorld);
    	}
    }
}