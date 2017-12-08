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

	private Snake player1;
	private Snake player2;

	private Random rand;
	private Timer t;

	private String direction1 = "";
	private String direction2 = "";

	Collectable startingCollectable;
	public KeyCounter keyCounter;
	private boolean movedThisTick;
	public int skin;
	public CurrentRun keep;


	//Keeps track of players.
	int playerCount = 2;




    public GameStageLocalMultiplayer(ScoreBoard scoreBoard, KeyCounter j, int f)
    {
    	setBackground("img/black.jpg");
    	skin=f;
    	keep = new CurrentRun();
    	this.scoreBoard = scoreBoard;
		addObject(this.scoreBoard, 50,50);
		rand = new Random();


		player1 = new Snake(100,100,null, this,skin, 1);

		//Trying to add another player. This one is mapped to the arrow keys.
		player2 = new Snake(180,180,null,this,skin, 2);

		startingCollectable	= new Collectable(player1, false, true);
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

		//Spawn in walls
		for (int i = 0; i < 30; i++) {
			for (int k = 0; k < 40; k++) {
				if(i == 0 || i == 29 || k == 0 || k == 39) {
					System.out.println("Spawning Walls");
					addObject(new Wall(false, true), k*20, i*20);
				}
			}
		}
	}

    public void tick()
    {
    	if(!direction1.equals("")) {
			player1.move(direction1);
		}
		if(!direction2.equals("")){
    		player2.move(direction2);
		}
    }

    public void removePlayer(Actor removeDis){
    	this.removeObject(removeDis);
    	System.out.println(playerCount);

    	if(playerCount >=2) {
			playerCount = playerCount - 1;
			System.out.println(playerCount);
		}
	}

	@Override
	public void act() {
    	if(!movedThisTick) {


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



			//end condition
			if(playerCount== 1){

				Snake winningS = (Snake)this.getObjects(Snake.class).get(0);
				if(winningS.playerNumber == 1){
					Mayflower.setWorld(new GameOver(this.scoreBoard, this.keyCounter, this.skin, this.keep, 1));
				}
				else if(winningS.playerNumber == 2){
					Mayflower.setWorld(new GameOver(this.scoreBoard, this.keyCounter, this.skin, this.keep, 2));
				}
				else if(winningS.playerNumber == 3){
					Mayflower.setWorld(new GameOver(this.scoreBoard, this.keyCounter, this.skin, this.keep, 3));
				}
				else if(winningS.playerNumber == 4){
					Mayflower.setWorld(new GameOver(this.scoreBoard, this.keyCounter, this.skin, this.keep, 4));
				}
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