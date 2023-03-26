package org.siit.homework.hw7Tema8;

import java.util.Comparator;

public class AthleteComparatorByFinalTime implements Comparator<Athlete> {

    @Override
    public int compare(Athlete athlete1, Athlete athlete2) {
        return Long.compare(athlete1.getFinalTime(), athlete2.getFinalTime());
    }
}
