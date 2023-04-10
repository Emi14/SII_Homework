package org.siit.projects.skiBiathlonStandings.model;

import java.util.List;

public class Athlete {
    private final int athleteNumber;
    private final String athleteName;
    private final CountryCode countryCode;
    private final int raceTime;
    private final List<String> shootingResults;
    private final int penalty;
    private final int finalRaceTime;
//    String athletePlace;

    public Athlete(int athleteNumber, String athleteName, String countryCode, String raceTime,
                   List<String> shootingResults) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = CountryCode.valueOf(countryCode);
        this.raceTime = determineRaceTimeInSeconds(raceTime);
        this.shootingResults = shootingResults;
        this.penalty = determineMissedShotsPenalty(shootingResults);
        this.finalRaceTime = determineFinalRaceTime();
    }

    private int determineRaceTimeInSeconds(String raceTime){
        //30:27
        String[] time = raceTime.split(":");
        return (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
    }
    private int determineMissedShotsPenalty(List<String> shootingResults) {
        int missedShots = 0;
        for(String result : shootingResults) {
            for (char c : result.toCharArray()) {
                if(c == 'o'){
                    missedShots++;
                }
            }
        }
        return missedShots * 10;
    }

    public int determineFinalRaceTime() {
        return raceTime + penalty;
    }
    @Deprecated
    public int getAthleteNumber() {
        return athleteNumber;
    }
    public String getAthleteName() {
        return athleteName;
    }
    @Deprecated
    public CountryCode getCountryCode() {
        return countryCode;
    }
    @Deprecated
    public int getRaceTime() {
        return raceTime;
    }


    @Deprecated
    public List<String> getShootingResults() {
        return shootingResults;
    }

    public int getFinalRaceTime() {
        return finalRaceTime;
    }

    @Override
    public String toString() {

        return " - " + athleteName + " " + (String.format("%02d", finalRaceTime/60) + ":" + String.format("%02d", finalRaceTime%60)) +
                " (" + raceTime/60 + ":" + raceTime%60 + " + " + penalty + ")";

    }
}
