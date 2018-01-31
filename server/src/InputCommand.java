public class InputCommand extends Command {

    @Override
    public CommandName getName() {
        return CommandName.INPUT;
    }

    @Override
    public void execute(int playerId, String[] args) {
        Direction dir = Direction.valueOf(args[0]);
        Main.game.getPlayer(playerId).setDirection(dir);
    }
}


