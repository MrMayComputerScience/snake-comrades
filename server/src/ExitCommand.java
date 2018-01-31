public class ExitCommand extends Command {

    @Override
    public CommandName getName() {
        return CommandName.EXIT;
    }

    @Override
    public void execute(int playerId, String[] args) {
        Main.game.players.remove(Main.game.getPlayer(playerId));
    }
}

