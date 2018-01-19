package game.online;

import game.Stages.ControlScheme;
import mayflower.Keyboard;
import mayflower.Mayflower;

import java.util.HashMap;
import java.util.Map;

public class InputManager {

    Map<Integer, Action> map;

    public InputManager() {
        map = new HashMap<>();

        map.put(Keyboard.KEY_W, Action.P1_UP);
        map.put(Keyboard.KEY_A, Action.P1_LEFT);
        map.put(Keyboard.KEY_S, Action.P1_DOWN);
        map.put(Keyboard.KEY_D, Action.P1_RIGHT);
        map.put(Keyboard.KEY_UP, Action.P2_UP);
        map.put(Keyboard.KEY_RIGHT, Action.P2_RIGHT);
        map.put(Keyboard.KEY_DOWN, Action.P2_DOWN);
        map.put(Keyboard.KEY_LEFT, Action.P2_LEFT);
    }

    public void tick() {
        for (Map.Entry<Integer, Action> e : map.entrySet()) {
            if(Mayflower.isKeyDown(e.getKey())) {
                performAction(e.getValue());
            }
        }
    }

    public void performAction(Action value) {

    }
}

enum Action {
    P1_UP,
    P1_LEFT,
    P1_RIGHT,
    P1_DOWN,
    P1_TICK,
    P1_DIE,
    P1_COLLECT,

    P2_UP,
    P2_LEFT,
    P2_RIGHT,
    P2_DOWN,
    P2_TICK,
    P2_DIE,
    P2_COLLECT,

    P3_UP,
    P3_LEFT,
    P3_RIGHT,
    P3_DOWN,
    P3_TICK,
    P3_DIE,
    P3_COLLECT,

    P4_UP,
    P4_LEFT,
    P4_RIGHT,
    P4_DOWN,
    P4_TICK,
    P4_DIE,
    P4_COLLECT,
}
