package game;

import java.util.Random;
import mayflower.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;


public class GameStage extends World
{
	public ScoreBoard scoreBoard;
	private Snake player;
	private Random rand;
	private Timer t;
	private String direction = "";
	Collectable startingCollectable;
	public KeyCounter keyCounter;
	private boolean movedThisTick;
	public int skin;
	public CurrentRun keep;

    public GameStage(ScoreBoard scoreBoard, KeyCounter j,int f)
    {
    	setBackground("img/black.png");
    	skin=f;
    	keep = new CurrentRun();
    	this.scoreBoard = scoreBoard;
		addObject(this.scoreBoard, 50,50);
		rand = new Random();
		player = new Snake(100,100, this,skin);
		startingCollectable	= new Collectable(player);
		addObject(player,100,100);

		//Adding collectable
		addObject(startingCollectable,120,120);
		t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				tick();
				movedThisTick = false;
			}
		}, 75, 75);

		keyCounter =j;
		addObject(keyCounter,50,65);
		addObject(keep,50,80);

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
    	if(!movedThisTick) {
			if ((Mayflower.isKeyPressed(Keyboard.KEY_W) || Mayflower.isKeyPressed(Keyboard.KEY_UP)) && !direction.equals("S")) {
				direction = ("N");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_A) || Mayflower.isKeyPressed(Keyboard.KEY_LEFT)) && !direction.equals("E")) {
				direction = ("W");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_S) || Mayflower.isKeyPressed(Keyboard.KEY_DOWN)) && !direction.equals("N")) {
				direction = ("S");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_D) || Mayflower.isKeyPressed(Keyboard.KEY_RIGHT)) && !direction.equals("W")) {
				direction = ("E");
				movedThisTick = true;
			}
		}
	}

	public void addCollectable(){
		Collectable a = new Collectable(player);
		Random rand = new Random();
		int x = rand.nextInt(780)+20;
		int y = rand.nextInt(580)+20;

		x= (x/20) *20;
		y = (y/20) * 20;

		if(x<=20){
			x= 100;
		}
		else if(x>=780){
			x = 680;
		}
		if(y <= 20){
			y=100;
		}
		else if(y>=580){
			y= 480;
		}

		boolean cantPlace = false;

		check:
		for(int i = 0; i <player.snakeLocationX.size(); i++)
		{
			if(x == player.snakeLocationX.get(i))
			{
				if(y == player.snakeLocationY.get(i)) {
					cantPlace = true;
					break check;
				}
			}
		}

		if(!cantPlace) {
			addObject(a, x, y);
			cantPlace = false;
		}
		else{
			addCollectable();
		}
		//Commenting out to see if recursive works because its more efficent.
		/*
		else{
	//		if this happens, we add a collectable to 120x120 if the snake is not there. If the snake is there, we add it to the bottom right.
			boolean cantPlace2 = false;
			check2:
			for(int i = 0; i <player.snakeLocationX.size(); i++)
			{
				if(120 == player.snakeLocationX.get(i))
				{
					if(120 == player.snakeLocationY.get(i)) {
						cantPlace2 = true;
						break check2;
					}
				}
			}
			if(!cantPlace2){
				this.addObject(a,120,120);
			}
		}\*/

	}














}