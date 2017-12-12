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

                if(array[r][c] == 1) {
                    System.out.println("Adding a wall.");
                    world.addObject(new Wall(), c * 20, r * 20);
                }
            }
        }
    }
}