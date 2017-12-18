package game.Stages;

import game.*;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.MayflowerImage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Snake extends TickingActor {

    private Snake following;
    private boolean dead;
    private Direction direction;
    private ControlScheme controlScheme;
    private int lastX, lastY;
    private UUID snakeGuid, guid;
    private MayflowerImage img;

    //Create a Minion
    public Snake(Snake following, UUID snakeGuid) {
        this.following = following;
        this.snakeGuid = snakeGuid;
        this.guid = UUID.randomUUID();

        img = new MayflowerImage("img/snakePhoto" + Main.snakeSkin + ".png");
    }

    //Create a Head
    public Snake(ControlScheme controlScheme, UUID snakeGuid) {
        this.controlScheme = controlScheme;
        this.snakeGuid = snakeGuid;
        this.guid = UUID.randomUUID();

        img = new MayflowerImage("img/snakePhoto" + Main.snakeSkin + ".png");
    }

    public UUID getSnakeGuid() {
        return snakeGuid;
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
            if(s.getSnakeGuid().equals(this.getSnakeGuid()) && s.isHead()) {
                return s;
            }
        }
        return null;
    }

    public Snake getTail() {
        for (Snake s : new ArrayList<>(getWorld().getObjects(Snake.class))) {
            if(s.getSnakeGuid().equals(this.getSnakeGuid()) && s.getFollower() == null) {
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

            //Updates
            this.setImage(img);
            System.out.println("x=" + getX() + ",y=" + getY() + ",guid=" + (getSnakeGuid().toString().substring(0,4)));
        }
    }

    private boolean movedThisTick = false;

    @Override
    public void act() {

        if(isDead()) {
            getWorld().removeObject(this);
        } else {
            if (!movedThisTick && isHead()) {

                if (Main.gameMode == GameMode.TWITCH_PLAYS_MULTIPLAYER) { //Twitch Control Scheme
                    if (areAllKeysDown(Direction.N) && direction != Direction.S) {
                        direction = Direction.N;
                        movedThisTick = true;
                    } else if (areAllKeysDown(Direction.N) && direction != Direction.E) {
                        direction = Direction.W;
                        movedThisTick = true;
                    } else if (areAllKeysDown(Direction.N) && direction != Direction.W) {
                        direction = Direction.E;
                        movedThisTick = true;
                    } else if (areAllKeysDown(Direction.N) && direction != Direction.N) {
                        direction = Direction.S;
                        movedThisTick = true;
                    }
                } else { //Default Control Scheme
                    if (Mayflower.isKeyDown(controlScheme.getUp()) && direction != Direction.S) {
                        direction = Direction.N;
                        movedThisTick = true;
                    } else if (Mayflower.isKeyDown(controlScheme.getLeft()) && direction != Direction.E) {
                        direction = Direction.W;
                        movedThisTick = true;
                    } else if (Mayflower.isKeyDown(controlScheme.getRight()) && direction != Direction.W) {
                        direction = Direction.E;
                        movedThisTick = true;
                    } else if (Mayflower.isKeyDown(controlScheme.getDown()) && direction != Direction.N) {
                        direction = Direction.S;
                        movedThisTick = true;
                    }
                }
            }

            if (Mayflower.isKeyPressed(Keyboard.KEY_PERIOD)) {
                extend();
            }
        }
    }

    private boolean areAllKeysDown(Direction d) {
        List<Direction> dirs = new ArrayList<>();

        for (int i = 0; i < Main.players; i++) {
            ControlScheme sch = ControlScheme.values()[i];

            if(Mayflower.isKeyDown(sch.getUp())) dirs.add(Direction.N);
            if(Mayflower.isKeyDown(sch.getLeft())) dirs.add(Direction.W);
            if(Mayflower.isKeyDown(sch.getDown())) dirs.add(Direction.S);
            if(Mayflower.isKeyDown(sch.getRight())) dirs.add(Direction.E);
        }

        if(dirs.stream().allMatch(n -> n == Direction.N) && d == Direction.N) return true;
        if(dirs.stream().allMatch(n -> n == Direction.W) && d == Direction.W) return true;
        if(dirs.stream().allMatch(n -> n == Direction.S) && d == Direction.S) return true;
        if(dirs.stream().allMatch(n -> n == Direction.E) && d == Direction.E) return true;
        return false;
    }

    public void extend() {
        if(getFollower() == null) {
            Snake newPart = new Snake(this, getHead().getSnakeGuid());
            getWorld().addObject(newPart, 0, 0);
            System.out.println("Extend snake");
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

        return guid.equals(snake.guid);
    }

    @Override
    public int hashCode() {
        return snakeGuid.hashCode();
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