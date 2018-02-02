import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameState {

    private Timer t;
    private long time0, time1;

    public State state;
    public List<Player> players;

    public GameState() {

        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                stick();
            }
        }, 75);

        state = State.LOBBY;
        players = new ArrayList<>();
    }

    private void stick(){
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

    private void tick()
    {
        //Do game logic here.
        if(state == State.GAME) {
            //send the map
        } else if(state == State.LOBBY) {
            val sb = new StringBuilder("LOBBY ");
            sb.append(players.size() + " ");
            //lenin
            //castro
            //stalin
            //mao

            Main.server.send(sb.toString().trim());
        }
    }

    public Player getPlayer(int playerId) {
        return players.stream().filter(n -> n.getPlayerId() == playerId).findFirst().orElse(null);
    }
}
