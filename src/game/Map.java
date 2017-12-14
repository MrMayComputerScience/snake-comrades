package game;

import mayflower.World;
import org.lwjgl.Sys;

public class Map {

    String name;
    int[][] array;

    public Map(String name, int[][] array) {
        this.name = name;
        this.array = array;
    }

    public void build(World world) {

        for (int r = 0; r < 30; r++) {
            for (int c = 0; c < 40; c++) {

                int i = array[r][c];
                int x = c * 20;
                int y = r * 20;

                if(i == 1) {
                    world.addObject(new Wall(), x, y);
                } else if(i == 2) {
                    world.addObject(new Portal(Portal.Color.BLUE), x, y);
                } else if(i == 3) {
                    world.addObject(new Portal(Portal.Color.RED), x, y);
                }
            }
        }
    }

    public void isOpenSpace(World world, int c, int r) {

    }
}