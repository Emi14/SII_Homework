package org.siit.homework.week8.service;

import org.siit.homework.week8.athlete.Athlete;
import org.siit.homework.week8.enums.CountryCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AthleteService {

    public List<Athlete> getAthletes(String csvContent) {
        String[] split = csvContent.split("\n");
        List<Athlete> athletes = new ArrayList<>();
        for(String athleteString : split) {
            String[] athleteValues = athleteString.split(",");
            Athlete athlete = new Athlete();
            athlete.setNumber(athleteValues[0]);
            athlete.setName(athleteValues[1]);
            athlete.setCountryCode(CountryCode.valueOf(athleteValues[2]));
            athlete.setTime(athleteValues[3]);
            athlete.setFirstShooting(athleteValues[4]);
            athlete.setSecondShooting(athleteValues[5]);
            athlete.setThirdShooting(athleteValues[6]);
            athletes.add(athlete);
        }
        return athletes;
    }

    public List<Athlete> orderAthletes(List<Athlete> athletes) {
        return athletes.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void printResults(List<Athlete> athletesResults) {
        List<Athlete> orderedAthletes = orderAthletes(athletesResults);
        for(int i = 0; i < orderedAthletes.size(); i++) {
            Athlete athlete = orderedAthletes.get(i);
            if (i == 0) {
                System.out.println("Winner - " + athlete);
            }
            if (i == 1) {
                System.out.println("Runner-up - " + athlete);
            }
            if (i == 2) {
                System.out.println("Third place - " + athlete);
            }
        }
    }
}
