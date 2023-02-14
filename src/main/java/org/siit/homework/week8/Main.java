package org.siit.homework.week8;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws Exception {

        List<Athlete> athlete = new ArrayList<>();
        FileReader file = new FileReader();
        File reader = new File("Athlete.txt");

        file.readFile(reader);
        file.winners();
        file.writeWinners();

    }
}
