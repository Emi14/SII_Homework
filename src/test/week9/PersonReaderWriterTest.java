package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week9.Main;
import org.siit.homework.week9.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonReaderWriterTest {private List<Person> people;

    @BeforeEach
    public void setUp() throws IOException {
        // Read input CSV file into a list of Person objects
        String inputFilePath = "src/main/resources/week9/inputNames.csv";
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        people = reader.lines()
                .map(line -> {
                    String[] fields = line.split(",");
                    String firstName = fields[0].trim();
                    String lastName = fields[1].trim();
                    LocalDate birthDate = LocalDate.parse(fields[2].trim(), formatter);
                    return new Person(firstName, lastName, birthDate);
                })
                .collect(Collectors.toList());
        reader.close();
    }

    @Test
    public void testFilterAndSortByBirthMonthAndName() {
        // Input parameters
        int targetMonth = 07; // July

        // Filter and sort people by birth month and name
        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getDateOfBirth().getMonthValue() == targetMonth)
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());

        // Check that the resulting list is sorted and contains only people with the target birth month
        Assertions.assertEquals(2, filteredPeople.size());
        Assertions.assertEquals("Kudrow", filteredPeople.get(0).getLastName());
        Assertions.assertEquals("Lisa", filteredPeople.get(0).getFirstName());
        Assertions.assertEquals("LeBlanc", filteredPeople.get(1).getLastName());
        Assertions.assertEquals("Matt", filteredPeople.get(1).getFirstName());
    }
}
