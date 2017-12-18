package game.Stages;

import game.GameOver;
import game.Main;
import mayflower.Mayflower;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameStage2 extends TickingStage {

    private List<Snake> snakes;

    public GameStage2() {
        setBackground("img/black.png");
        snakes = new ArrayList<>();

        for (int i = 0; i < Main.players; i++) {
            Snake s = new Snake(ControlScheme.values()[i], UUID.randomUUID());
            snakes.add(s);

            if(i == 0)
                addObject(s, 40, 40);
            else if(i == 1)
                addObject(s, 740, 40);
            else if(i == 2)
                addObject(s, 40, 540);
            else if(i == 3)
                addObject(s, 740, 540);
        }

        Main.map.build(this);

        if(Main.gameMode.isCollectable())
            Main.map.spawnCollectable(this);
    }

    @Override
    public void act() {

        System.out.println("Actors = " + this.getObjects().size());

        if(!Main.gameMode.isMulti() && snakes.stream().allMatch(Snake::isDead)) {
            Mayflower.setWorld(new GameOver());
        } else if(Main.gameMode.isMulti()) {
            for (Snake s : snakes) {
                List<Snake> others = new ArrayList<>(snakes);
                others.removeIf(n -> n.getUuid() == s.getUuid());

                if(!s.isDead() && others.stream().allMatch(Snake::isDead)) {
                    Mayflower.setWorld(new GameOver(snakes.indexOf(s) + 1));
                }
            }
        }
    }
}