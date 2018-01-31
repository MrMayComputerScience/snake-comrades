import mayflower.net.Server;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.List;

public class SnakeServer extends Server {

    private List<Command> commands;
    private List<Integer> clients;

    public SnakeServer() {
        super(1917, true); //Russian revolution date

        clients = new ArrayList<>();

        commands = new ArrayList<>();
        commands.add(new JoinCommand());
        commands.add(new ExitCommand());

        commands.add(new InputCommand());

        commands.add(new EchoCommand());

        //Finished starting up.
        start();
        System.out.println("Server started on port 1917.");
    }

    @Override
    public void process(int playerId, String s) {
        String[] args = s.split(" ");
        CommandName name = CommandName.valueOf(args[0]);
        System.out.println("[SnakeClient" + playerId + "::" + name + "] " + s);

        commands.forEach(n -> {
            if(n.getName() == name) {
                n.execute(playerId, args);
            }
        });
    }

    @Override
    public void onJoin(int playerId) {
        clients.add(playerId);
        process(playerId, CommandName.JOIN.toString());
    }

    @Override
    public void onExit(int playerId) {
        clients.remove((Integer) playerId);
        process(playerId, CommandName.EXIT.toString());
    }
}
