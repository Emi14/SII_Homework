package org.siit.homework.week8;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class BiathlonStandingsTest {
    // Test for parsing the CSV file and creating a list of BiathlonAthlete objects
    @Test
    public void testCsvParsing() {
        String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx\n";
        List<BiathlonAthlete> athletes = BiathlonStandings.parseCsv(csv);
        assertEquals(3, athletes.size());
        assertEquals(11, athletes.get(0).getAthleteNumber());
        assertEquals("Umar Jorgson", athletes.get(0).getAthleteName());
        assertEquals("SK", athletes.get(0).getCountryCode());
        assertEquals("30:27", athletes.get(0).getSkiTimeResult());
        assertEquals("xxxoxxxxxxxoxo", athletes.get(0).getShootingRangeResults());
    }

    // Test for calculating the final standings
    @Test
    public void testStandingsCalculation() {
        String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx\n";
        List<BiathlonAthlete> athletes = BiathlonStandings.parseCsv(csv);
        BiathlonStandings.calculateStandings(athletes);
        // sort the list by final time in ascending order
        Collections.sort(athletes, new BiathlonAthleteComparator());
        assertEquals("Piotr Smitzer", athletes.get(0).getAthleteName());
        assertEquals("30:10", athletes.get(0).getFinalTime());
        assertEquals("Jimmy Smiles", athletes.get(1).getAthleteName());
        assertEquals("30:15", athletes.get(1).getFinalTime());
        assertEquals("Umar Jorgson", athletes.get(2).getAthleteName());
        assertEquals("30:57", athletes.get(2).getFinalTime());
    }

    private static class BiathlonStandings {
        public static List<BiathlonAthlete> parseCsv(String csv) {
            return null;
        }

        public static void calculateStandings(List<BiathlonAthlete> athletes) {
        }
    }
}
