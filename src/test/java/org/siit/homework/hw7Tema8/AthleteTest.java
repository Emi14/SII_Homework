package org.siit.homework.hw7Tema8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AthleteTest {

    Athlete athlete;

    @BeforeEach
    void setUp() throws Exception {
        athlete = new Athlete(11, "Umar Jorgson", Country.SK, "30:27", "xxxox", "xxxxx", "xxoxo");
    }

    @Test
    void testCalculatePenalties() {
        athlete.calculatePenalties();
        assertEquals(30, athlete.getPenaltyTime());
    }

    @Test
    void testCalculateFinalTime() {
        athlete.calculateFinalTime();
        assertEquals(1857, athlete.getFinalTime());
    }

    @Test
    void testAthleteNameAndTime() {
        athlete.calculateFinalTime();
        assertEquals("Umar Jorgson 30:57 (30:27 + 30)", athlete.athleteNameAndTime());
    }
}
