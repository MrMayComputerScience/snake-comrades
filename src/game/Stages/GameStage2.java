package game.Stages;

import game.GameMode;
import game.GameOver;
import game.Main;
import game.StartMenu;
import mayflower.Mayflower;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameStage2 extends TickingStage {

    private List<Snake> snakes;

    public GameStage2() {
        snakes = new ArrayList<>();

        for (int i = 0; i < Main.players; i++) {

            //Skip adding more than first snake for these modes.
            if((Main.gameMode == GameMode.TWITCH_PLAYS_MULTIPLAYER
                    || Main.gameMode == GameMode.SNAKE_MOUSE_MULTIPLAYER)
                    && i != 0) {
                break;
            }

            Snake s = new Snake(ControlScheme.values()[i], UUID.randomUUID());
            snakes.add(s);

            System.out.println("Added snake " + i);

            if(i == 0)
                addObject(s, 40, 40);
            if (i == 1)
                addObject(s, 740, 40);
            if (i == 2)
                addObject(s, 40, 540);
            if (i == 3)
                addObject(s, 740, 540);
        }

        Main.map.build(this);

        if(Main.gameMode.isCollectable())
            Main.map.spawnCollectable(this);
    }

    @Override
    public void act() {
        System.out.println("Actors = " + this.getObjects().size());

        if(Main.gameMode == GameMode.TWITCH_PLAYS_MULTIPLAYER) {
            if(snakes.stream().anyMatch(Snake::isDead)) {
                System.out.println("Deaded");
                Mayflower.setWorld(new GameOver());
            }
        } else if(!Main.gameMode.isMulti() && snakes.stream().allMatch(Snake::isDead)) {
            Mayflower.setWorld(new GameOver());
        } else if(Main.gameMode.isMulti()) {
            for (Snake s : snakes) {
                List<Snake> others = new ArrayList<>(snakes);
                others.removeIf(n -> n.getSnakeGuid() == s.getSnakeGuid());

                if(!s.isDead() && others.stream().allMatch(Snake::isDead)) {
                    Mayflower.setWorld(new GameOver(snakes.indexOf(s) + 1));
                }
            }
        }
    }
}