package game; /**
 * @(#)ScoreBoard.java
 *
 *
 * @author
 * @version 1.00 2017/5/8
 */

import mayflower.*;
public class CurrentRun extends Actor
{
    private int score;

    public CurrentRun()
    {
        score = 0;
        setImage(new MayflowerImage("Current run score: " + score, 16, new Color(0,255,0)));
    }

    public void plusScore()
    {
        score++;
    }

    public int getScore()
    {
        return score;
    }

    @Override
    public void act()
    {
        setImage(new MayflowerImage("Current run score: " + getScore(), 16, new Color(0,255,0)));
    }
}