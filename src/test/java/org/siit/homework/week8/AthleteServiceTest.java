package org.siit.homework.week8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week8.athlete.Athlete;
import org.siit.homework.week8.service.AthleteService;
import org.siit.homework.week8.enums.CountryCode;

import java.util.ArrayList;
import java.util.List;

class AthleteServiceTest {

    private AthleteService athleteService;

    @BeforeEach
    public void init() {
        athleteService = new AthleteService();
    }

    @Test
    void givenTheStringWhenAthleteServiceGetAthletesThenAthletesAreReturnedTest() {
        // given
        String given = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        String expectedFirstName = "Umar Jorgson";
        String expectedNumber = "11";
        String expectedCountryCode = CountryCode.SK.name();

        // when
        List<Athlete> actual = athleteService.getAthletes(given);

        // then
        Assertions.assertEquals(1,actual.size(), "The list should contain one element");
        Assertions.assertEquals(expectedFirstName, actual.get(0).getName(), "Athlete name doesn't match");
        Assertions.assertEquals(expectedNumber, actual.get(0).getNumber(), "Athlete number doesn't match");
        Assertions.assertEquals(expectedCountryCode, actual.get(0).getCountryCode().name(), "Athlete country code doesn't match");
    }

    @Test
    void givenAnAthleteListWhenAthleteServiceOrderAthletesThenAthletesAreOrderedTest() {
        // given
        List<Athlete> unorderedAthletes = new ArrayList<>();
        Athlete athlete1 = new Athlete("1", "Jimmy Smiles", CountryCode.UK, "29:15", "xxoox", "xooxo", "xxxxo");
        Athlete athlete2 = new Athlete("27", "Piotr Smitzer", CountryCode.CZ, "30:10", "xxxxx", "xxxxx", "xxxxx");
        unorderedAthletes.add(athlete1);
        unorderedAthletes.add(athlete2);

        // when
        List<Athlete> actualOrderedAthletes = athleteService.orderAthletes(unorderedAthletes);

        // then
        Assertions.assertEquals("Piotr Smitzer", actualOrderedAthletes.get(0).getName(), "Piotr should be first");
    }
}