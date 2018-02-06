public class EchoCommand extends Command {

    @Override
    public CommandName getName() {
        return CommandName.ECHO;
    }

    @Override
    public void execute(int playerId, String[] args) {
        Main.server.send(playerId, "PRINTLN " + String.join(" ", args));
    }
}
