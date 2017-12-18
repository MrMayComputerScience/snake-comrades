package game; /**
 * @(#)startMenu.java
 *
 *
 * @author 
 * @version 1.00 2017/5/1
 */

import game.Stages.GameStage2;
import game.Stages.TickingStage;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.MayflowerMusic;

public class StartMenu extends TickingStage
{
	private LongMenuButton singleplayer, localMulti, netMulti;
	private ShortMenuButton lootboxes, quit;
	private MapChooseButton mapChooser;
	private ModeChooseButton modeChooser;
	public static MayflowerMusic currentSong;
	public static String music;
	public static BackgroundImage matrix;

    public StartMenu()
    {
    	music = "jazz";
    	setBackground("img/titlescreen_minecraft.png");

    	singleplayer = new LongMenuButton();
    	localMulti = new LongMenuButton();
    	netMulti = new LongMenuButton();
    	lootboxes = new ShortMenuButton();
    	quit = new ShortMenuButton();
    	mapChooser = new MapChooseButton();
    	modeChooser = new ModeChooseButton();

    	addObject(singleplayer, 233, 246);
    	addObject(localMulti, 233, 246+48);
    	addObject(netMulti, 233, 246+48*2);
    	addObject(lootboxes, 233, 414);
    	addObject(quit, 403, 414);
    	addObject(mapChooser, 233, 514);
    	addObject(modeChooser, 233, 514-48);

		currentSong = new MayflowerMusic("audio/jazz.wav");
		currentSong.play();
		currentSong.setVolume(1);
	}

    @Override
    public void act()
    {
		if(Mayflower.mouseClicked(singleplayer)) {
			if(!Main.gameMode.isMulti()) {
                GameStage2 nextWorld = new GameStage2();
                Mayflower.setWorld(nextWorld);
            }
		}
		if(Mayflower.mouseClicked(localMulti)){
            if(Main.gameMode.isMulti()) {
                HowManyPlayersSelect h = new HowManyPlayersSelect();
                Mayflower.setWorld(h);
            }
		}

		if(Mayflower.mouseClicked(lootboxes)) {
			LootboxWorld nextWorld = new LootboxWorld();
			Mayflower.setWorld(nextWorld);
		}

		if(Mayflower.mouseClicked(quit)) {
			Mayflower.exit();
		}

		if (Mayflower.isKeyDown(Keyboard.KEY_GRAVE))
		{
			scoreBoard.addKeyScore();
		}
    }
}