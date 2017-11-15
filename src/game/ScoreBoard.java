package game; /**
 * @(#)ScoreBoard.java
 *
 *
 * @author 
 * @version 1.00 2017/5/8
 */

import mayflower.*;
public class ScoreBoard extends Actor
{
	private int score;

    public ScoreBoard()
    {
    	score = 0;
    	setImage(new MayflowerImage("Score: " + score, 16, new Color(0,255,0)));
    }

    public void plusScore()
    {
    	score++;
    	act();
    }
    public void minusScore()
    {
        score-=249;
        act();
    }

    public int getScore()
    {
    	return score;
    }
    
    @Override
    public void act()
    {
    	setImage(new MayflowerImage("Score: " + getScore(), 16, new Color(0,255,0)));
    }
}