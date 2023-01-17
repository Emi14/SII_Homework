package org.siit.homework.week8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AthleteTest {
    @Test
    public void testCalculatePenalties() {
        Athlete athlete = new Athlete(1, "Jimmy Smiles",Country.UK,"29:15","xxoox", "xooxo", "xxxxo");
        athlete.calculatePenalties();
        Assertions.assertEquals(60,athlete.getPenaltyTime());
    }
    @Test
    public void testCalculatePenaltiesZero() {
        Athlete athlete = new Athlete(1, "Jimmy Smiles",Country.UK,"29:15","xxxxx", "xxxxx", "xxxxx");
        athlete.calculatePenalties();
        Assertions.assertEquals(0,athlete.getPenaltyTime());
    }
    @Test
    public void testCalculateFinalTime() {
        Athlete athlete = new Athlete(1, "Jimmy Smiles",Country.UK,"29:15","xxoox", "xooxo", "xxxxo");
        athlete.calculateFinalTime();
        Assertions.assertEquals(1815,athlete.getFinalTime());
    }

}
