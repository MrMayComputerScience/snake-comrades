package game.Stages;

import mayflower.Keyboard;

public enum ControlScheme {
    WASD(Keyboard.KEY_W, Keyboard.KEY_A, Keyboard.KEY_S, Keyboard.KEY_D),
    ARROWS(Keyboard.KEY_UP, Keyboard.KEY_LEFT, Keyboard.KEY_DOWN, Keyboard.KEY_RIGHT),
    TFGH(Keyboard.KEY_T, Keyboard.KEY_F, Keyboard.KEY_G, Keyboard.KEY_H),
    IJKL(Keyboard.KEY_I, Keyboard.KEY_J, Keyboard.KEY_K, Keyboard.KEY_L),
    ;

    private int up, left, down, right;

    ControlScheme(int up, int left, int down, int right) {
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
    }

    public int getUp() {
        return up;
    }

    public int getLeft() {
        return left;
    }

    public int getDown() {
        return down;
    }

    public int getRight() {
        return right;
    }
}
