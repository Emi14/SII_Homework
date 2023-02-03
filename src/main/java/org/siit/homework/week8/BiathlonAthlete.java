package org.siit.homework.week8;

import java.util.Arrays;

public class BiathlonAthlete {
    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult;
    private String shootingRangeResults;
    private String finalTime;

    public BiathlonAthlete(int athleteNumber, String athleteName, String countryCode, String skiTimeResult,
                           String shootingRangeResults) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.shootingRangeResults = shootingRangeResults;
        this.finalTime = skiTimeResult;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setSkiTimeResult(String skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public String getShootingRangeResults() {
        return shootingRangeResults;
    }

    public void setShootingRangeResults(String shootingRangeResults) {
        this.shootingRangeResults = shootingRangeResults;
    }

    public String getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(String finalTime) {
        this.finalTime = finalTime;
    }

    // calculate the final time by adding the penalty for missed shots
    public void calculateFinalTime() {
        int penalty = 0;
        for (char c : shootingRangeResults.toCharArray()) {
            if (c == 'o') {
                penalty += 10;
            }
        }
        String[] time = skiTimeResult.split(":");
        int minutes = Integer.parseInt(time[0]);
        int seconds = Integer.parseInt(time[1]);
        seconds += penalty;
        minutes += seconds / 60;
        seconds = seconds % 60;
        finalTime = minutes + ":" + String.format("%02d", seconds);
    }
}