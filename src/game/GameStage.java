package game;

import java.security.Key;
import java.util.Random;
import mayflower.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;


public class GameStage extends World
{
	private ScoreBoard scoreBoard;
	private Snake player;
	private Random rand;
	private Timer t;
	private String direction = "";
	Collectable startingCollectable;
	private KeyCounter k;

    public GameStage(ScoreBoard scoreBoard, KeyCounter j)
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

		k=j;
		addObject(k,50,65);

		//Spawn in walls
		for (int i = 0; i < 30; i++) {
			for (int k = 0; k < 40; k++) {
				if(i == 0 || i == 29 || k == 0 || k == 39) {
					addObject(new Wall(), k*20, i*20);
				}
			}
		}
	}

    public void tick()
    {
    	if(!direction.equals("")) {
			player.move(direction);
		}
    }




	@Override
	public void act() {
		if(Mayflower.isKeyPressed(Keyboard.KEY_W) && !direction.equals("S")) {
			direction = ("N");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_A) && !direction.equals("E")) {
			direction = ("W");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_S) && !direction.equals("N")) {
			direction = ("S");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_D) && !direction.equals("W")) {
			direction = ("E");
		} else if(Mayflower.isKeyPressed(Keyboard.KEY_GRAVE)) {
			player.increaseSnakeSize();
		}
	}

	public void addCollectable(){
		Collectable a = new Collectable(player);
		Random rand = new Random();
		int x = rand.nextInt(780)+20;
		int y = rand.nextInt(580) + 20;
		addObject(a,x,y);

	}














}