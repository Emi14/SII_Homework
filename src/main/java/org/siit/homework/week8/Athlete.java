package org.siit.homework.week8;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Athlete
{
    Integer AthleteNumber;
    String AthleteName;
    String CountryCode;
    String SkiTimeResult;
    String FirstShootingRange;
    String SecondShooting;
    String ThirdShooting;
    Integer minutes;
    Integer seconds;
    Integer penalty;
    Integer overallTime;



    public Athlete(int athleteNumber, String athleteName, String countryCode, Integer minutes, Integer seconds, String firstShootingRange, String secondShooting, String thirdShooting) {
        AthleteNumber = athleteNumber;
        AthleteName = athleteName;
        CountryCode = countryCode;
        this.minutes = minutes;
        this.seconds = seconds;
        SkiTimeResult = minutes.toString() + ":" +seconds.toString();
        FirstShootingRange = firstShootingRange;
        SecondShooting = secondShooting;
        ThirdShooting = thirdShooting;
        overallTime = minutes*60 + seconds;
    }
    @Override
    public String toString() {
        return "Athlete{" +
                "AthleteNumber=" + AthleteNumber +
                ", AthleteName='" + AthleteName + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", SkiTimeResult=" + minutes + ":" + seconds +
                ", FirstShootingRange='" + FirstShootingRange + '\'' +
                ", SecondShooting='" + SecondShooting + '\'' +
                ", ThirdShooting='" + ThirdShooting + '\'' +
                '}'+'\n';
    }

}
