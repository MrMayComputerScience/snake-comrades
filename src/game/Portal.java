package game;

import lombok.Getter;
import lombok.val;
import mayflower.Actor;

import javax.sound.sampled.Port;

public class Portal extends Actor {

    private Color color;

    public Color getColor() {
        return color;
    }

    public Portal(Color color) {

        this.color = color;
    }

    @Override
    public void act() {

        Color oppColor = color.getOpposite();
        Portal oppPortal = getWorld().getObjects(Portal.class).stream().filter(n -> n != null && n.getColor() == oppColor).findFirst().get();

        if(isTouching(Snake.class)) {
            Snake snake = getOneIntersectingObject(Snake.class);
            snake.move(oppPortal.getX(), oppPortal.getY());
        }
    }

    enum Color {
        RED,
        BLUE;

        private Color opposite;

        static {
            RED.opposite = BLUE;
            BLUE.opposite = RED;
        }

        public Color getOpposite() {
            return opposite;
        }
    }
}
