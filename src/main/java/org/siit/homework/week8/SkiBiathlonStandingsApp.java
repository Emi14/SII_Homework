package org.siit.homework.week8;

import org.siit.homework.week8.athlete.Athlete;
import org.siit.homework.week8.service.AthleteService;
import org.siit.homework.week8.reader.CSVReader;

import java.io.IOException;
import java.util.List;


public class SkiBiathlonStandingsApp {

    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader();
        String content = reader.readCsv("src/main/resources/week8/athletes.csv");
        System.out.println(content);
        AthleteService athleteService = new AthleteService();
        List<Athlete> athletes = athleteService.getAthletes(content);
        athleteService.printResults(athletes);
    }
}
