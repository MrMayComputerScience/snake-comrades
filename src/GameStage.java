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
	private Snake player;
	private Random rand;
    public GameStage(ScoreBoard a)
    {
    	setBackground("img/blue.png");
    	s=a;
		addObject(s, 50,50);
		rand = new Random();
		player = new Snake(100,100);
		addObject(player,100,100);
    }
    
    @Override
    public void act()
    {

    }
}