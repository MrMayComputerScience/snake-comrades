package game;


import mayflower.Actor;
import mayflower.MayflowerImage;
import org.lwjgl.Sys;

import javax.sound.sampled.Port;

public class Portal extends Actor {

    private Color color;

    public Color getColor() {
        return color;
    }

    public Portal(Color color) {

        this.color = color;

        setImage(color.getImage());
    }

    @Override
    public void act() {

        Color oppColor = color.getOpposite();
        Portal oppPortal = getWorld().getObjects(Portal.class).stream().filter(n -> n != null && n.getColor() == oppColor).findFirst().get();

        if(this.isTouching(SnakePart.class)) {
            SnakePart snake = getOneIntersectingObject(SnakePart.class);

            int x = oppPortal.getX();
            int y = oppPortal.getY();

            //todo fix
            snake.move(x, y);
        }
    }

    enum Color {
        RED("img/portal0.png"),
        BLUE("img/portal1.png");

        private Color opposite;
        private String image;

        static {
            RED.opposite = BLUE;
            BLUE.opposite = RED;
        }

        public Color getOpposite() {
            return opposite;
        }

        public String getImage() {
            return image;
        }

        Color(String image) {
            this.image = image;
        }
    }
}
