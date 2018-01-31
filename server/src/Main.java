import mayflower.net.Server;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static SnakeServer server;
    public static GameState game;

    public static void main(String[] args) {
        server = new SnakeServer();
        game = new GameState();
    }
}

