package game.Stages;

import game.CurrentRun;
import game.KeyCounter;
import game.Main;
import game.ScoreBoard;
import mayflower.World;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class TickingStage extends World {

    private Timer t;
    private long time0, time1;

    protected ScoreBoard scoreBoard;
    protected KeyCounter keyCounter;
    protected CurrentRun currentRun;

    public TickingStage() {

        scoreBoard = Main.scoreBoard;
        keyCounter = Main.keyCounter;
        currentRun = Main.currentRun;

        addObject(scoreBoard, 50,50);
        addObject(keyCounter,50,50 + 15);
        addObject(currentRun,50,50 + 30);

        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                stick();
            }
        }, 75);
    }

    public void stick() {
        tick();

        if(time0 == 0 || time1 == 0) {
            time0 = System.currentTimeMillis();
            time1 = System.currentTimeMillis();
        }

        time0 = time1;
        time1 = System.currentTimeMillis();

        long diff = Math.abs(time1 - time0);
        long excess = diff - 75;

        t.schedule(new TimerTask() {
            @Override
            public void run() {
                stick();
            }
        }, excess > 1000 || excess < 1 ? 75 : 75 - excess);
    }

    public void tick()
    {
        new ArrayList<>(getObjects()).forEach(n -> {
            if (n instanceof TickingActor) ((TickingActor) n).tick();
        });
    }
}
