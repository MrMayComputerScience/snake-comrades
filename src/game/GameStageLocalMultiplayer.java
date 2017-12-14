package game;

import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.World;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class GameStageLocalMultiplayer extends World
{
	public ScoreBoard scoreBoard;

	//All four snakes
	public Snake player1;
	public boolean dead1;

	public Snake player2;
	public boolean dead2;

	public Snake player3;
	public boolean dead3;

	public Snake player4;
	public boolean dead4;

	private Random rand;
	private Timer t;

	private String direction1 = "";
	private String direction2 = "";
	private String direction3 = "";
	private String direction4 = "";

	Collectable startingCollectable;
	public KeyCounter keyCounter;
	private boolean movedThisTick;
	public int skin;
	public CurrentRun keep;

	//Keeps track of players.
	int playerCount = 4;

    public GameStageLocalMultiplayer(ScoreBoard scoreBoard, KeyCounter j, int f, int pCount)
    {
    	Main.gameMode = GameMode.LOCAL_MULTIPLAYER;
			playerCount = pCount;

    	setBackground("img/black.jpg");
    	skin=f;
    	keep = new CurrentRun();
    	this.scoreBoard = scoreBoard;
		addObject(this.scoreBoard, 50,50);
		rand = new Random();

		player1 = new Snake(40, 40, null, this, skin, 1);
		if(playerCount >=2) {
			player2 = new Snake(760,40,null,this,skin, 2);
		}
		if(playerCount>=3) {
			player3 = new Snake(40, 560, null, this, skin, 3);
		}
		if(playerCount ==4) {
			player4 = new Snake(760, 560, null, this, skin, 4);

		}

		startingCollectable	= new Collectable(player1, false, true);
		addObject(player1,20,20);
		if(playerCount>=2) {
			addObject(player2, 760, 40);
		}
		if(playerCount >=3) {
			addObject(player3, 40, 560);
		}
		if(playerCount == 4) {
			addObject(player4, 760, 560);
		}


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

		//Spawn in the map
		if(Main.map == null)
			Main.map = MapReader.maps.get(0); //Basic Map

		Main.map.build(this);
	}

    public void tick()
    {
    	if(!dead1) {
			if (!direction1.equals("")) {
				player1.move(direction1);
			}
		}
		if(!dead2) {
			if (!direction2.equals("")) {
				player2.move(direction2);
			}
		}
		if(!dead3) {
			if (!direction3.equals("")) {
				player3.move(direction3);
			}
		}
		if(!dead4) {
			if (!direction4.equals("")) {
				player4.move(direction4);
			}
		}
    }

    public void removePlayer(Actor removeDis){

    	System.out.println(playerCount);

    	if(playerCount >=2) {
			Snake a = (Snake)removeDis;
			int snakeNu = a.playerNumber;
			System.out.println("Removing this snake number " +snakeNu);
			//checking which snake is about to die.
			if(snakeNu == 1){
				dead1 = true;
			}
			else if(snakeNu == 2){
				dead2 = true;
			}
			else if(snakeNu == 3){
				dead3 = true;
			}
			else if(snakeNu == 4){
				dead4 = true;
			}
			for(int i = 0; i < a.snakeParts.size(); i++){
				this.removeObject(a.snakeParts.get(i));
			}

			playerCount = playerCount - 1;
			System.out.println(playerCount);
		}
		this.removeObject(removeDis);
	}

	@Override
	public void act() {
    	if(!movedThisTick) {

			//player1
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

			//player2
			if ((Mayflower.isKeyPressed(Keyboard.KEY_UP)&& !direction2.equals("S"))) {
				direction2 = ("N");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_LEFT)  && !direction2.equals("E"))) {
				direction2 = ("W");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_DOWN)  && !direction2.equals("N"))) {
				direction2 = ("S");
				movedThisTick = true;
			} else if ((Mayflower.isKeyPressed(Keyboard.KEY_RIGHT)  && !direction2.equals("W"))) {
				direction2 = ("E");
				movedThisTick = true;
			}

			//player3
			if ((Mayflower.isKeyPressed(Keyboard.KEY_T)) && !direction3.equals("S")) {
				direction3 = ("N");
				movedThisTick = true;
			} else if (Mayflower.isKeyPressed(Keyboard.KEY_F) && !direction3.equals("E")) {
				direction3 = ("W");
				movedThisTick = true;
			} else if (Mayflower.isKeyPressed(Keyboard.KEY_G) && !direction3.equals("N")) {
				direction3 = ("S");
				movedThisTick = true;
			} else if (Mayflower.isKeyPressed(Keyboard.KEY_H) && !direction3.equals("W")) {
				direction3 = ("E");
				movedThisTick = true;
			}

			//player4
			if ((Mayflower.isKeyPressed(Keyboard.KEY_I)) && !direction4.equals("S")) {
				direction4 = ("N");
				movedThisTick = true;
			} else if (Mayflower.isKeyPressed(Keyboard.KEY_J) && !direction4.equals("E")) {
				direction4 = ("W");
				movedThisTick = true;
			} else if (Mayflower.isKeyPressed(Keyboard.KEY_K) && !direction4.equals("N")) {
				direction4 = ("S");
				movedThisTick = true;
			} else if (Mayflower.isKeyPressed(Keyboard.KEY_L) && !direction4.equals("W")) {
				direction4 = ("E");
				movedThisTick = true;
			}

			//end condition
			if(playerCount== 1){

				if(!dead1){
					Mayflower.setWorld(new GameOver(this.scoreBoard, this.keyCounter, this.skin, this.keep, 1));
				}
				else if(!dead2){
					Mayflower.setWorld(new GameOver(this.scoreBoard, this.keyCounter, this.skin, this.keep, 2));
				}
				else if(!dead3){
					Mayflower.setWorld(new GameOver(this.scoreBoard, this.keyCounter, this.skin, this.keep, 3));
				}
				else if(!dead4){
					Mayflower.setWorld(new GameOver(this.scoreBoard, this.keyCounter, this.skin, this.keep, 4));
				}
				//I originally tried to get a list of Snake actors, but I would get an Index Out of Bounds Exception, so I did it
				//this way.
			}

		}
	}

	public void addCollectable(){
		Collectable a = new Collectable(player1, false, true);
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


	}














}