package org.siit.homework.week8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class Athlete implements Comparable<Athlete> {
    private int athleteNumber;
    private String athleteName;
    private ISOCountryCode countryCode;
    private String skiTimeResult;
    private String[] shootingResults;
    private int totalTime;

    public Athlete(int athleteNumber, String athleteName, ISOCountryCode countryCode, String skiTimeResult, String[] shootingResults) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.shootingResults = shootingResults;
        this.totalTime = calculateTotalTime();
    }

    @Override
    public int compareTo(Athlete other) {
        return Double.compare(this.totalTime, other.totalTime);
    }

    public int calculateTotalTime() {
        int timeSeconds = skiTimeSeconds();
        for (String shootingResult : shootingResults) {
            for (char shotResult : shootingResult.toCharArray()) {
                if (shotResult == 'o') {
                    timeSeconds += 10;
                }
            }
        }
        return timeSeconds;
    }

    @Override
    public String toString() {
        String formattedTime = String.format("%d:%02d", totalTime / 60, totalTime % 60);
        return athleteName + " " + formattedTime + " (" + skiTimeResult + " + " + (totalTime - skiTimeSeconds()) + ")";
    }

    private int skiTimeSeconds() {
        String[] skiTimeFields = skiTimeResult.split(":");
        int skiTimeMinutes = Integer.parseInt(skiTimeFields[0]);
        int skiTimeSeconds = Integer.parseInt(skiTimeFields[1]);
        return skiTimeMinutes * 60 + skiTimeSeconds;
    }
}