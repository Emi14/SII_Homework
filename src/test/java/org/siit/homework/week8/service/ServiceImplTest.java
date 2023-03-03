package org.siit.homework.week8.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week8.model.Athlete;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceImplTest {

    ServiceImpl serviceImpl;
    Athlete athlete;

    @BeforeEach
    void setUp() {
        serviceImpl = new ServiceImpl();
    }

    @Test
    void determineStandings() {

    }

    @Test
    void writeResults() {
    }


    @Test
    void testParseCSV_whenFileIsFound_ThenResultsAreShown() {
        List<Athlete> athleteList = serviceImpl.parseCSV("src/main/resources/resultsIO.csv");
        assertNotNull(athleteList);
        assertFalse(athleteList.isEmpty());
    }

//    @Test
//    void testParseCSV_whenReadingLine_thenCorrectInformationIsReceived() {
//        String line = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
//        String[] columns = line.split(",");
//        assertEquals("Umar Jorgson", serviceImpl.parseCSV(String line).get(0).getAthleteName()));
//    }

}