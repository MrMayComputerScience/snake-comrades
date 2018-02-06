public abstract class Command {
    abstract public CommandName getName();
    abstract public void execute(int playerId, String[] args);
}

