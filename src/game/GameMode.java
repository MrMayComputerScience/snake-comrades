package game;

public enum GameMode {
    //From 0 to 5 in this order.
    //0
    SINGLEPLAYER("Basic", false, true),
    //1
    LOCAL_MULTIPLAYER("Basic", true, true),
    //2
    TWITCH_PLAYS_MULTIPLAYER("Twitch Plays", true, true),
    //3
    SNAKE_MOUSE_MULTIPLAYER("Snake & Mouse", true, false),
    //4
    ALWAYS_GROW_SINGLEPLAYER("Always Grow", false, false),
    //5
    ALWAYS_GROW_MULTIPLAYER("Always Grow", true, false);

    private String text;
    private boolean multi;
    private boolean collectable;

    GameMode(String text, boolean multi, boolean collectable) {
        this.text = text;
        this.multi = multi;
        this.collectable = collectable;
    }

    public String getText() {
        return text + " [" + (multi ? "MP" : "SP") + "]";
    }

    public boolean isMulti() {
        return multi;
    }

    public boolean isCollectable() {
        return collectable;
    }
}