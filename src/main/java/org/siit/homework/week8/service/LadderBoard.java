package org.siit.homework.week8.service;

import org.siit.homework.week8.enums.CountryCode;
import org.siit.homework.week8.model.Athlete;

import java.io.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LadderBoard implements LadderBoardService {

    @Override
    public void readFile(Set<Athlete> athleteSet, String filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                generateCollection(athleteSet, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateCollection(Set<Athlete> athleteSet, String line) {
        String[] split = line.split(",");
        if (split[4].length() != 5 || split[5].length() != 5 || split[6].length() != 5) {
            throw new IllegalArgumentException("Wrong input format for " + split[1] + " shooting results");
        }
        List<String> shootingResults = Arrays.asList(split[4], split[5], split[6]);
        int numberOfMissedShots = calculateMissedShots(shootingResults);
        Duration raceDuration = calculateTotalRaceTime(split[3], numberOfMissedShots);
        String totalRaceTime = durationToString(raceDuration);
        athleteSet.add(new Athlete(Integer.parseInt(split[0]), split[1], CountryCode.valueOf(split[2]), split[3],
                shootingResults, numberOfMissedShots, totalRaceTime, raceDuration));
    }

    @Override
    public int calculateMissedShots(List<String> shootingResults) {
        char findChar = 'o';
        int charCount = 0;
        for (String elem : shootingResults) {
            elem = elem.toLowerCase().trim();
            if (elem.contains("o")) {
                for (char ch : elem.toCharArray()) {
                    if (ch == findChar) {
                        ++charCount;
                    }
                }
            }
        }
        return charCount;
    }

    @Override
    public Duration calculateTotalRaceTime(String raceTime, int missedShots) {
        return stringToDuration(raceTime).plusSeconds(missedShots * 10L);
    }

    @Override
    public String durationToString(Duration duration) {
        char[] durationCharArray = duration.toString().toCharArray();
        return switch (durationCharArray.length) {
            case 5 -> String.valueOf(durationCharArray[2]) + durationCharArray[3] + ":00";
            case 7 -> String.valueOf(durationCharArray[2]) + durationCharArray[3] + ":0" + durationCharArray[5];
            default -> String.valueOf(durationCharArray[2]) + durationCharArray[3] + ":" + durationCharArray[5] + durationCharArray[6];
        };
    }

    @Override
    public Duration stringToDuration(String time) {
        String[] splitRaceTime = time.split(":");
        return Duration.ofMinutes(Integer.parseInt(splitRaceTime[0])).plusSeconds(Integer.parseInt(splitRaceTime[1]));
    }

    @Override
    public void writeResults(Set<Athlete> athleteSet, String output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            StringBuilder builder = new StringBuilder();
            Iterator<Athlete> iterator = athleteSet.iterator();
            Athlete next = iterator.next();
            builder.append("Winner - ").append(next.getName()).append( " ")
                    .append(next.getTotalRaceTime()).append(" (").append(next.getRaceTime()).append(" + ")
                    .append(next.getMissedShots() * 10).append(")").append('\n');
            next = iterator.next();
            builder.append("Runner-up - ").append(next.getName()).append( " ")
                    .append(next.getTotalRaceTime()).append(" (").append(next.getRaceTime()).append(" + ")
                    .append(next.getMissedShots() * 10).append(")").append('\n');
            next = iterator.next();
            builder.append("Third Place - ").append(next.getName()).append( " ")
                    .append(next.getTotalRaceTime()).append(" (").append(next.getRaceTime()).append(" + ")
                    .append(next.getMissedShots() * 10).append(")").append('\n');
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
