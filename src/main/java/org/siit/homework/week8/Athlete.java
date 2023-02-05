package org.siit.homework.week8;

public class Athlete {
    private int number;
    private String name;
    private Country country;
    private String raceTimeFirst;
    private String shootingRange1;
    private String shootingRange2;
    private String shootingRange3;
    private long finalTime;
    private long penaltyTime;



    public Athlete(int number, String name, Country country, String raceTimeFirst, String shootingRange1, String shootingRange2, String shootingRange3) {
        this.number = number;
        this.name = name;
        this.country = country;
        this.raceTimeFirst = raceTimeFirst;
        this.shootingRange1 = shootingRange1;
        this.shootingRange2 = shootingRange2;
        this.shootingRange3 = shootingRange3;
    }
    public void calculatePenalties() {
        long counter = shootingRange1.chars().filter(ch -> ch == 'o').count();
        counter += shootingRange2.chars().filter(ch -> ch == 'o').count();
        counter += shootingRange3.chars().filter(ch -> ch == 'o').count();
        penaltyTime = counter * 10;
    }
    public void calculateFinalTime() {
        calculatePenalties();
        String[] s = raceTimeFirst.split(":");
       finalTime = Integer.parseInt(s[0]) * 60L + Integer.parseInt(s[1]) + penaltyTime;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", country='" + country.getCountryName() + '\'' +
                ", raceTimeFirst='" + raceTimeFirst + '\'' +
                ", shootingRange1='" + shootingRange1 + '\'' +
                ", shootingRange2='" + shootingRange2 + '\'' +
                ", shootingRange3='" + shootingRange3 + '\'' +
                '}';
    }
    public String athleteNameAndTime() {
        long minutes = finalTime / 60;
        long seconds = finalTime % 60;

        return name + " " + minutes + ":" + seconds + " (" + raceTimeFirst + " + " + penaltyTime + ")";
    }
    public long getFinalTime() {
        return finalTime;
    }

    public long getPenaltyTime() {
        return penaltyTime;
    }
}
