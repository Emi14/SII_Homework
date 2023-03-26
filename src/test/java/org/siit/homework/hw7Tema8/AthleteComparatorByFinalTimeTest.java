package org.siit.homework.hw7Tema8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AthleteComparatorByFinalTimeTest {
    Athlete athlete1;
    Athlete athlete2;
    Athlete athlete3;
    AthleteComparatorByFinalTime comparator;

    @BeforeEach
    void setUp() throws Exception {
        athlete1 = new Athlete(11, "Umar Jorgson", Country.SK, "30:27", "xxxox", "xxxxx", "xxoxo");
        athlete2 = new Athlete(1, "Jimmy Smiles", Country.UK, "29:15", "xxoox", "xooxo", "xxxxo");
        athlete3 = new Athlete(27, "Piotr Smitzer", Country.CZ, "30:10", "xxxxx", "xxoxx", "xxxxx");

        comparator = new AthleteComparatorByFinalTime();
    }

    @Test
    void testCompare() {
        athlete1.calculateFinalTime();
        athlete2.calculateFinalTime();
        athlete3.calculateFinalTime();

        List<Athlete> aList = new ArrayList<>();
        aList.add(athlete1);
        aList.add(athlete2);
        aList.add(athlete3);

        Collections.sort(aList, comparator);

        assertEquals(athlete2, aList.get(0));
        assertEquals(athlete3, aList.get(1));
        assertEquals(athlete1, aList.get(2));
    }

}
