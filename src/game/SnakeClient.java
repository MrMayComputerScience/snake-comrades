package game;

import mayflower.net.Client;

public class SnakeClient extends Client {

    @Override
    public void process(String s) {
        if(s.startsWith("PRINTLN ")) {
            System.out.println("[SnakeServer] " + s.substring(8).trim());
        }
        if(s.startsWith("MAP ")) {
            String map = s.substring(4).trim();

        }
    }

    @Override
    public void onDisconnect(String s) {

    }

    @Override
    public void onConnect() {
        send("ECHO my test message hello world!");
    }
}
