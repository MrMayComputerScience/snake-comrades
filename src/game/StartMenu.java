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
    	if(music == null) music = "jazz";
    	//matrix = new BackgroundImage();
    	setBackground("img/titlescreen_minecraft.png");

    	singleplayer = new LongMenuButton();
    	localMulti = new LongMenuButton();
    	netMulti = new LongMenuButton();
    	lootboxes = new ShortMenuButton();
    	quit = new ShortMenuButton();
   		mapChooser = new MapChooseButton();

    	addObject(singleplayer, 233, 246);
    	addObject(localMulti, 233, 246+48);
    	addObject(netMulti, 233, 246+48*2);
    	addObject(lootboxes, 233, 414);
    	addObject(quit, 403, 414);
    	addObject(mapChooser, 233, 514);

    	if(currentSong == null) {
			currentSong = new MayflowerMusic("audio/jazz.wav");
			currentSong.play();
			currentSong.setVolume(1);
		}
	}

    @Override
    public void act()
    {
		if(Mayflower.mouseClicked(singleplayer)) {
			//Need to put in game.ModeSelect calls.
			ModeSelect a = new ModeSelect(true,false);
			Mayflower.setWorld(a);
		}
		if(Mayflower.mouseClicked(localMulti)){
            ModeSelect a = new ModeSelect(false, true);
			Mayflower.setWorld(a);
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