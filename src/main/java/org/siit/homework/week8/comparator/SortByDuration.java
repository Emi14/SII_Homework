package org.siit.homework.week8.comparator;

import org.siit.homework.week8.model.Athlete;

import java.util.Comparator;

public class SortByDuration implements Comparator<Athlete> {
    @Override
    public int compare(Athlete o1, Athlete o2) {
        return o1.getDuration().compareTo(o2.getDuration());
    }
}
