package org.siit.projects.skiBiathlonStandings.comparator;

import org.siit.projects.skiBiathlonStandings.model.Athlete;

import java.util.Comparator;

public class AthleteComparatorByFinalRaceTime implements Comparator<Athlete> {
    @Override
    public int compare(Athlete o1, Athlete o2) {
        return o1.getFinalRaceTime() - o2.getFinalRaceTime();
    }
}
