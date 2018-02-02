import lombok.Getter;
import lombok.Setter;

public class Player {

    @Getter int playerId;
    @Getter @Setter Direction direction;

    public Player(int playerId) {
        this.playerId = playerId;
    }
}
