package org.siit.homework.hw7Tema8;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/AthleteList.csv";
        List<Athlete> aList = readCSVFile(filePath);
        // calculate penalties
        for (Athlete a : aList) {
            a.calculateFinalTime();
        }
        Collections.sort(aList, new AthleteComparatorByFinalTime());
        System.out.println("Winner - " + aList.get(0).

                athleteNameAndTime());
        System.out.println("Runner-Up - " + aList.get(1).

                athleteNameAndTime());
        System.out.println("Third Place - " + aList.get(2).

                athleteNameAndTime());

    }

    public static List<Athlete> readCSVFile(String filePath) {
        List<Athlete> aList = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] s = line.split(",");
                Athlete athlete = new Athlete(Integer.parseInt(s[0]), s[1], Country.getCountryEnum(s[2]), s[3], s[4], s[5], s[6]);
                aList.add(athlete);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aList;
    }
}
