package org.siit.homework.hw7Tema8;

public class Athlete {
    private final Integer number;
    private final String name;
    private final Country countryCode;
    private final String skiTimeResult;
    private final String firstShootingRange;
    private final String secondShooting;
    private final String thirdShooting;
    private Long finalTime;
    private Long penaltyTime;

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Country getCountryCode() {
        return countryCode;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public String getSecondShooting() {
        return secondShooting;
    }

    public String getThirdShooting() {
        return thirdShooting;
    }

    public Athlete(int number, String name, Country country, String skiTimeResult, String firstShootingRange, String secondShooting, String thirdShooting) {
        this.number = number;
        this.name = name;
        this.countryCode = country;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
    }

    public void calculatePenalties() {
        long counter = firstShootingRange.chars().filter(ch -> ch == 'o').count();
        counter += secondShooting.chars().filter(ch -> ch == 'o').count();
        counter += thirdShooting.chars().filter(ch -> ch == 'o').count();
        penaltyTime = counter * 10;
    }

    public void calculateFinalTime() {
        calculatePenalties();
        String[] s = skiTimeResult.split(":");
        finalTime = Integer.parseInt(s[0]) * 60L + Integer.parseInt(s[1]) + penaltyTime;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "number =" + number +
                ", name ='" + name + '\'' +
                ", country ='" + countryCode.getCountryName() + '\'' +
                ", raceTimeFirst ='" + skiTimeResult + '\'' +
                ", shootingRange1 ='" + firstShootingRange + '\'' +
                ", shootingRange2 ='" + secondShooting + '\'' +
                ", shootingRange3 ='" + thirdShooting + '\'' +
                '}';
    }

    public String athleteNameAndTime() {
        long minutes = finalTime / 60;
        long seconds = finalTime % 60;

        return name + " " + minutes + ":" + seconds + " (" + skiTimeResult + " + " + penaltyTime + ")";
    }

    public long getFinalTime() {
        return finalTime;
    }

    public long getPenaltyTime() {
        return penaltyTime;
    }
}
