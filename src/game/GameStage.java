package game;

import java.util.Random;
import mayflower.*;
import java.util.Timer;
import java.util.TimerTask;


public class GameStage extends World
{
	public ScoreBoard scoreBoard;

	private Snake player1;


	private Random rand;
	private Timer t;

	private String direction1 = "";
	private String direction2 = "";


	Collectable startingCollectable;
	public KeyCounter keyCounter;
	private boolean movedThisTick;
	public int skin;
	public CurrentRun keep;
	public BackgroundImage matrix;

    public GameStage(ScoreBoard scoreBoard, KeyCounter j,int f)
    {
    	setBackground("img/background.gif");
    	matrix=new BackgroundImage();
    	Main.gameMode = GameMode.SINGLEPLAYER;
    	skin=f;
    	keep = new CurrentRun();
    	this.scoreBoard = scoreBoard;
		addObject(this.scoreBoard, 50,50);
		rand = new Random();

		player1 = new Snake(40,40, this,null,skin, 1);

		startingCollectable	= new Collectable(player1);
		addObject(player1,100,100);

		//Adding collectable
		addObject(startingCollectable,160,160);
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

		//Spawn map
		if(Main.map == null)
			Main.map = MapReader.maps.get(0); //Basic Map

		Main.map.build(this);
	}

    public void tick()
    {
    	if(!direction1.equals("")) {
			player1.move(direction1);
		}
    }

	@Override
	public void act() {
    	matrix.nextImage(this);

		System.out.println("Objects: " + getObjects().size());

    	if(!movedThisTick) {

    		//Commenting out to keep old work in the case that the new code breaks the program.
    		/*
			if ((Mayflower.isKeyPressed(Keyboard.KEY_W) || Mayflower.isKeyPressed(Keyboard.KEY_UP)) && !direction1.equals("S")) {
				direction1 = ("N");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_A) || Mayflower.isKeyPressed(Keyboard.KEY_LEFT)) && !direction1.equals("E")) {
				direction1 = ("W");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_S) || Mayflower.isKeyPressed(Keyboard.KEY_DOWN)) && !direction1.equals("N")) {
				direction1 = ("S");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_D) || Mayflower.isKeyPressed(Keyboard.KEY_RIGHT)) && !direction1.equals("W")) {
				direction1 = ("E");
				movedThisTick = true;
			}
		*/

			if ((Mayflower.isKeyPressed(Keyboard.KEY_W)&& !direction1.equals("S"))) {
				direction1 = ("N");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_A)  && !direction1.equals("E"))) {
				direction1 = ("W");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_S)  && !direction1.equals("N"))) {
				direction1 = ("S");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_D)  && !direction1.equals("W"))) {
				direction1 = ("E");
				movedThisTick = true;
			}
			//adding section for player1 two.

			if ((Mayflower.isKeyPressed(Keyboard.KEY_UP)) && !direction1.equals("S")) {
				direction2 = ("N");
				movedThisTick = true;
			} else if (Mayflower.isKeyPressed(Keyboard.KEY_LEFT) && !direction1.equals("E")) {
				direction2 = ("W");
				movedThisTick = true;
			} else if (Mayflower.isKeyPressed(Keyboard.KEY_DOWN) && !direction1.equals("N")) {
				direction2 = ("S");
				movedThisTick = true;
			} else if (Mayflower.isKeyPressed(Keyboard.KEY_RIGHT) && !direction1.equals("W")) {
				direction2 = ("E");
				movedThisTick = true;
			}



		}
	}

	public void addCollectable(){
		Collectable a = new Collectable(player1);
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
		for(int i = 0; i < player1.snakeLocationX.size(); i++)
		{
			if(x == player1.snakeLocationX.get(i))
			{
				if(y == player1.snakeLocationY.get(i)) {
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
			for(int i = 0; i <player1.snakeLocationX.size(); i++)
			{
				if(120 == player1.snakeLocationX.get(i))
				{
					if(120 == player1.snakeLocationY.get(i)) {
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