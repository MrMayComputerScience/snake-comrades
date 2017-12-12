package game;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapReader {

    public static List<Map> maps;

    public static void initialize() throws Exception {
        maps = new ArrayList<>();

        for(File f : new File("maps").listFiles()) {
            System.out.println("Found map " + f.getName());

            Scanner s = new Scanner(f);
            String name = s.nextLine().trim();
            int[][] array = new int[30][40];

            for (int i = 0; i < 30; i++) {
                String line = s.nextLine().trim();
                String[] parts = line.split(",");
                int[] partsint = new int[parts.length];

                for (int j = 0; j < parts.length; j++) {
                    partsint[j] = Integer.parseInt(parts[j]);
                }

                array[i] = partsint;
            }

            maps.add(new Map(name, array));
        }
    }
}

