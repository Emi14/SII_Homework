package org.siit.homework.week8;

import java.util.Comparator;

public class BiathlonAthleteComparator implements Comparator<BiathlonAthlete> {
    @Override
    public int compare(BiathlonAthlete a1, BiathlonAthlete a2) {
        String[] time1 = a1.getFinalTime().split(":");
        int minutes1 = Integer.parseInt(time1[0]);
        int seconds1 = Integer.parseInt(time1[1]);
        String[] time2 = a2.getFinalTime().split(":");
        int minutes2 = Integer.parseInt(time2[0]);
        int seconds2 = Integer.parseInt(time2[1]);
        if (minutes1 == minutes2) {
            return seconds1 - seconds2;
        }
        return minutes1 - minutes2;
    }
}