package org.siit.homework.week8;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
//
//                       ---> Ski Biathlon Standings <---
//
//  - write a software that takes as an input a CSV file where every entry represents the results of a biathlon athlete
//  - based on the entries identify the first 3 places (Winner, Runner-up and Third Place)
//  - the rules are simple, each athlete has a time-results for the entire skiing session, and 3 shooting range results
//  - each shooting range has 5 shot results
//  - for every missed shot the athlete obtains a 10 seconds penalty which affects the final time-result
//  - final standings are based on the time-results that have been updated with the shooting range results
//  - every shooting range consists of 5 characters, where x means hit, o mean miss
//  - for every o there should be 10 seconds added to the final time
//
    public static void main(String[] args) {

        String filePath = "src/main/resources/ListWeek8.csv";
        List<Athlete> aList = readCSVFile(filePath);
        // calculate penalties
        for (Athlete a : aList) {
            a.calculateFinalTime();
        }

        Collections.sort(aList, new AthleteComparatorByFinalTime());
        System.out.println("Winner - " + aList.get(0).athleteNameAndTime());
        System.out.println("Runner-Up - " + aList.get(1).athleteNameAndTime());
        System.out.println("Third Place - " + aList.get(2).athleteNameAndTime());

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

    ////// TESTS AVAILABLE. PLEASE CHECK HERE: src/test/java/org/siit/homework/week8 //////

}
