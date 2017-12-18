package game;

public enum GameMode {
    SINGLEPLAYER("Basic", false, true),
    LOCAL_MULTIPLAYER("Basic", true, true),
    TWITCH_PLAYS_MULTIPLAYER("Twitch Plays", true, true),
    SNAKE_MOUSE_MULTIPLAYER("Snake & Mouse", true, false),
    ALWAYS_GROW_SINGLEPLAYER("Always Grow", false, false),
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