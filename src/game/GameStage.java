package game;

import java.security.Key;
import java.util.Random;
import mayflower.*;

public class GameStage extends World
{
	private ScoreBoard scoreBoard;
	private Snake player;
	private Random rand;

    public GameStage(ScoreBoard scoreBoard)
    {
    	setBackground("img/blue.png");
    	this.scoreBoard = scoreBoard;
		addObject(this.scoreBoard, 50,50);
		rand = new Random();
		player = new Snake(100,100, this);
		addObject(player,100,100);
    }
    
    @Override
    public void act()
    {
		if(Mayflower.isKeyPressed(Keyboard.KEY_W)) {
			player.move("N");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_A)) {
			player.move("W");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_S)) {
			player.move("S");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_D)) {
			player.move("E");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_GRAVE)) {
			player.increaseSnakeSize();
		}
    }
}