package week9Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week9.personServices.Person;
import org.siit.homework.week9.personServices.PersonServiceCls;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceClsTest {

    private static PersonServiceCls personService;

    @BeforeEach
    void setUp() {
        personService = new PersonServiceCls();
    }

    @Test
    void testManipulateData_whenInputListIsEmpty_thenReturnAnEmptyList() {
        List<Person> personList = new ArrayList<>();
        personService.manipulateData(personList, 1);
        assertTrue(personList.isEmpty());
    }

    @Test
    void testManipulateData_whenInputMonthIsNotInTheList_thenReturnAnEmptyList() {
        List<Person> personList = Collections.singletonList(
                new Person("Nicolae", "Dandu", LocalDate.of(1995, 10, 1)));
        personList = personService.manipulateData(personList, 1);
        assertTrue(personList.isEmpty());
    }

    @Test
    void testManipulateData_whenInputIsValid_thenReturnAListNotEmpty() {
        List<Person> personList = Arrays.asList(
                new Person("Dandu", "Dandu", LocalDate.of(1995, 10, 1)),
                new Person("Ion", "Neculce", LocalDate.of(1978, 7, 17)),
                new Person("Gica", "Hagi", LocalDate.of(1980, 7, 25)));
        personList = personService.manipulateData(personList, 7);
        assertFalse(personList.isEmpty());
        assertEquals(2, personList.size());
    }

}
