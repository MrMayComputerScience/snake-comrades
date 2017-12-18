package game.Stages;

import game.*;
import mayflower.Keyboard;
import mayflower.Mayflower;

import java.util.ArrayList;
import java.util.UUID;

public class Snake extends TickingActor {

    private Snake following;
    private boolean dead;
    private Direction direction;
    private ControlScheme controlScheme;
    private int lastX, lastY;
    private UUID uuid;

    //Create a Minion
    public Snake(Snake following, UUID uuid) {
        this.following = following;
        this.uuid = uuid;
        setImage("img/snakePhoto" + Main.snakeSkin + ".png");
    }

    //Create a Head
    public Snake(ControlScheme controlScheme, UUID uuid) {
        this.controlScheme = controlScheme;
        this.uuid = uuid;
        setImage("img/snakePhoto" + Main.snakeSkin + ".png");
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isHead() {
        return following == null;
    }

    public Snake getFollowing() {
        return following;
    }

    public boolean isDead() {
        if(isHead()) return dead;
        return getHead() == null || getHead().isDead();
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public Snake getFollower() {
        for (Snake s : new ArrayList<>(getWorld().getObjects(Snake.class))) {
            if(s.getFollowing() == this) {
                return s;
            }
        }
        return null;
    }

    public Snake getHead() {
        for (Snake s : new ArrayList<>(getWorld().getObjects(Snake.class))) {
            if(s.getUuid().equals(this.getUuid()) && s.isHead()) {
                return s;
            }
        }
        return null;
    }

    public Snake getTail() {
        for (Snake s : new ArrayList<>(getWorld().getObjects(Snake.class))) {
            if(s.getUuid().equals(this.getUuid()) && s.getFollower() == null) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void tick() {
        movedThisTick = false;

        if(!dead) {
            //Movement Code
            lastX = getX();
            lastY = getY();

            if(isHead()) {
                int x = getX();
                int y = getY();

                if(this.isTouching(Portal.class)) {
                    Portal p = getOneIntersectingObject(Portal.class);
                    p = p.getOppositePortal();
                    x = p.getX();
                    y = p.getY();
                }

                if (direction == Direction.N) y -= 20;
                if (direction == Direction.E) x += 20;
                if (direction == Direction.S) y += 20;
                if (direction == Direction.W) x -= 20;

                setLocation(x, y);
            } else {
                setLocation(following.getLastX(), following.getLastY());
            }

            //Collision Code
            if(this.isHead() && direction != null) {
                if (this.isTouching(Snake.class) || this.isTouching(Wall.class)) {
                    kill();
                } else if (this.isTouching(Collectable.class)
                        || Main.gameMode == GameMode.ALWAYS_GROW_SINGLEPLAYER
                        || Main.gameMode == GameMode.ALWAYS_GROW_MULTIPLAYER) {

                    getTail().extend();
                    Main.currentRun.plusScore();
                    Main.scoreBoard.plusScore();

                    if(this.isTouching(Collectable.class)) {
                        this.removeTouching(Collectable.class);
                        Main.map.spawnCollectable(getWorld());
                    }
                }
            }
        }
    }

    private boolean movedThisTick = false;

    @Override
    public void act() {

        if(isDead()) {
            getWorld().removeObject(this);
        } else {
            if (!movedThisTick && isHead()) {

                if (Mayflower.isKeyDown(controlScheme.getUp()) && direction != Direction.S) {
                    direction = Direction.N;
                } else if (Mayflower.isKeyDown(controlScheme.getLeft()) && direction != Direction.E) {
                    direction = Direction.W;
                } else if (Mayflower.isKeyDown(controlScheme.getRight()) && direction != Direction.W) {
                    direction = Direction.E;
                } else if (Mayflower.isKeyDown(controlScheme.getDown()) && direction != Direction.N) {
                    direction = Direction.S;
                }

                movedThisTick = true;
            }

            if (Mayflower.isKeyPressed(Keyboard.KEY_PERIOD)) {
                extend();
            }
        }
    }

    public void extend() {
        if(getFollower() == null) {
            Snake newPart = new Snake(this, this.getUuid());
            getWorld().addObject(newPart, getX(), getY());
        }
    }

    public void kill() {
        getHead().dead = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snake snake = (Snake) o;

        return uuid.equals(snake.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}

enum Direction {
    N, E, S, W
}

enum ControlScheme {
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