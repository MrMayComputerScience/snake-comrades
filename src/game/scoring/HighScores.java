package game.scoring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HighScores {

    private static final String filename = "highscores.txt";

    public List<Entry> get() {
        File f = new File(filename);
        List<Entry> list = new ArrayList<>();

        if (f.exists()) {
            try {
                Scanner s = new Scanner(f);
                while(s.hasNextLine()) {
                    String line = s.nextLine().trim();

                    if(!line.equals("")) {
                        String initials = line.substring(0,2);
                        long score = Long.parseLong(line.substring(3));
                        list.add(new Entry(initials, score));
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public void add(String initials, long score) {
        Entry e = new Entry(initials, score);

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(filename, true));
            bw.write(e.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bw != null) try {
                bw.close();
            } catch (IOException ioe2) {
                // just ignore it
            }
        }
    }
}

class Entry {

    String initials;
    long score;

    public String getInitials() {
        return initials;
    }

    public long getScore() {
        return score;
    }

    public Entry(String initials, long score) {
        this.initials = initials;
        this.score = score;
    }

    @Override
    public String toString() {
        return initials + "" + score;
    }
}