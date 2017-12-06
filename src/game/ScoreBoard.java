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
	private boolean dirty = false;

    public ScoreBoard()
    {
    	score = 0;
    	setImage(new MayflowerImage("Score: " + score, 16, new Color(0,255,0)));
    }

    public void plusScore()
    {
    	score++;
        dirty = true;
    }

    public void addKeyScore()
    {
        score +=249;
        dirty = true;
    }

    public void minusKeyScore()
    {
        score-=249;
        dirty = true;
    }

    public int getScore()
    {
    	return score;
    }
    
    @Override
    public void act()
    {
        if(dirty) {
            setImage(new MayflowerImage("Score: " + getScore(), 16, new Color(0, 255, 0)));
            dirty = false;
        }
    }
}