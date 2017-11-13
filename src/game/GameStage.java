package game;

import java.security.Key;
import java.util.Random;
import mayflower.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameStage extends World
{
	private ScoreBoard scoreBoard;
	private Snake player;
	private Random rand;
	private Timer t;
	private String direction = "";
	Collectable startingCollectable;

    public GameStage(ScoreBoard scoreBoard)
    {

    	setBackground("img/blue.png");
    	this.scoreBoard = scoreBoard;
		addObject(this.scoreBoard, 50,50);
		rand = new Random();
		player = new Snake(100,100, this);
		startingCollectable	= new Collectable(player);
		addObject(player,100,100);

		//Adding collectable

		addObject(startingCollectable,120,120);
		t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				tick();
			}
		}, 75, 75);
    }

    public void tick()
    {
    	if(!direction.equals("")) {
			player.move(direction);
		}
    }




	@Override
	public void act() {
		if(Mayflower.isKeyPressed(Keyboard.KEY_W)) {
			direction = ("N");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_A)) {
			direction = ("W");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_S)) {
			direction = ("S");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_D)) {
			direction = ("E");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_GRAVE)) {
			player.increaseSnakeSize();
		}
	}
}