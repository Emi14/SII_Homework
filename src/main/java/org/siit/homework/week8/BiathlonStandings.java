package org.siit.homework.week8;

import java.util.ArrayList;
import java.util.List;

public class BiathlonStandings {
    public static List<BiathlonAthlete> parseCsv(String csv) {
        List<BiathlonAthlete> athletes = new ArrayList<>();
        String[] lines = csv.split("\n");
        for (String line : lines) {
            String[] values = line.split(",");
            int athleteNumber = Integer.parseInt(values[0]);
            String athleteName = values[1];
            String countryCode = values[2];
            String skiTimeResult = values[3];
            String shootingRangeResults = values[4] + values[5] + values[6];
            athletes.add(new BiathlonAthlete(athleteNumber, athleteName, countryCode, skiTimeResult, shootingRangeResults));
        }
        return athletes;
    }

    public static void calculateStandings(List<BiathlonAthlete> athletes) {
        for (BiathlonAthlete athlete : athletes) {
            athlete.calculateFinalTime();
        }
    }
}



