package org.siit.homework.week8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        // Read the CSV file
        List<Athlete> athletes = readCSVFile("src/main/resources/week8/biathlon_results.csv");

        // Calculate the total time for each athlete
        athletes.forEach(Athlete::calculateTotalTime);

        // Sort the athletes by their total time
        List<Athlete> sortedAthletes = athletes.stream()
                .sorted(Comparator.comparing(Athlete::getTotalTime))
                .collect(Collectors.toList());

        // Print the top three athletes
        System.out.println("Winner - " + sortedAthletes.get(0));
        System.out.println("Runner-up - " + sortedAthletes.get(1));
        System.out.println("Third Place - " + sortedAthletes.get(2));
    }

    public static List<Athlete> readCSVFile(String fileName) throws IOException {
        List<Athlete> athletes;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            athletes = br.lines()
                    .map(line -> {
                        String[] fields = line.split(",");
                        int athleteNumber = Integer.parseInt(fields[0]);
                        String athleteName = fields[1];
                        ISOCountryCode countryCode = ISOCountryCode.valueOf(fields[2]);
                        String skiTimeResult = fields[3];
                        String[] shootingResults = new String[]{
                                fields[4],
                                fields[5],
                                fields[6]
                        };
                        return new Athlete(athleteNumber, athleteName, countryCode, skiTimeResult, shootingResults);
                    })
                    .collect(Collectors.toList());
        }
        return athletes;
    }
}
