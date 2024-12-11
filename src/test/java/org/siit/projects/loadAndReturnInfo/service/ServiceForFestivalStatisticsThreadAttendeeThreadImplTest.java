package org.siit.projects.loadAndReturnInfo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.projects.loadAndReturnInfo.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceForFestivalStatisticsThreadAttendeeThreadImplTest {

    private static ServiceForPersonImpl serviceForPerson;

    @BeforeEach
    void setUp() {
        serviceForPerson = new ServiceForPersonImpl();
    }

    @Test
    void testSplitListLines_whenInputIsRead_thenPersonIsCreated() {
        String line = "Maria, Gagenescu, 1988-10-10";
        List<String> lines = new ArrayList<>();
        lines.add(line);
        serviceForPerson.splitListLines(lines);
        assertEquals("Maria", serviceForPerson.splitListLines(lines).get(0).getFirstName());
        assertEquals("Gagenescu", serviceForPerson.splitListLines(lines).get(0).getLastName());
        assertEquals(10, serviceForPerson.splitListLines(lines).get(0).getMonthOfBirth());
    }

    @Test
    void testManipulateData_whenInputIsValid_ThenListReturnedIsNotEmpty() {
        List<Person> personList = Arrays.asList(
                new Person("Ali", "Baba", 9),
                new Person("Fat", "Frumos", 8),
                new Person("Zmeul", "Neinfricat", 8));
        personList = serviceForPerson.manipulateData(personList, 8);
        assertFalse(personList.isEmpty());
        assertEquals(2, personList.size());
    }

    @Test
    void testManipulateData_whenTargetMonthIsNotPresentInTheInputFile_ThenListReturnedIsEmpty() {
        List<Person> personList = Arrays.asList(
                new Person("Ali", "Baba", 9),
                new Person("Fat", "Frumos", 8),
                new Person("Zmeul", "Neinfricat", 8));
        personList = serviceForPerson.manipulateData(personList, 3);
        assertTrue(personList.isEmpty());
    }
}