/**
 * @(#)GameStage.java
 *
 *
 * @author 
 * @version 1.00 2017/5/1
 */
import java.util.Random;
import mayflower.*;
public class GameStage extends World
{
	private ScoreBoard s;
    public GameStage(ScoreBoard a)
    {
    	setBackground("img/blue.png");
    	s=a;
		addObject(s, 50,50);
    }
    
    @Override
    public void act()
    {

    }
}