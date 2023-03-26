package org.siit.homework.week8.athlete;

import lombok.*;
import org.siit.homework.week8.enums.CountryCode;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Athlete implements Comparable<Athlete> {
    private String number;
    private String name;
    private CountryCode countryCode;
    private String time;
    private String firstShooting;
    private String secondShooting;
    private String thirdShooting;

    public int getTotalTimeInSeconds() {
        int raceTime = getRaceTime();
        int penalties = getPenalties();
        return raceTime + penalties;
    }

    private int getRaceTime() {
        String[] split = time.split(":");
        int minutes = Integer.parseInt(split[0]);
        int seconds = Integer.parseInt(split[1]);
        return minutes * 60 + seconds;
    }

    public int getPenalties() {
        String hits = firstShooting + secondShooting + thirdShooting;
        int miss = 0;
        for (int i = 0; i < hits.length(); i++) {
            if (hits.charAt(i) == 'o') {
                miss++;
            }
        }
        return miss * 10;
    }

    @Override
    public int compareTo(Athlete o) {
        return -o.getTotalTimeInSeconds();
    }

    @Override
    public String toString() {
        int minutes = getTotalTimeInSeconds() / 60;
        int remainingSeconds = getTotalTimeInSeconds() - minutes * 60;
        String totalTime = minutes + ":" + remainingSeconds;
        return getName() + " " + totalTime
                + " (" + getTime() + " + " + getPenalties() + ")";
    }
}
