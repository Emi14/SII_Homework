package week9;

import org.apache.commons.validator.GenericValidator;
import org.junit.jupiter.api.Test;
import org.siit.homework.week9.model.Person;
import org.siit.homework.week9.service.PersonService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private final List<Person> testPersonList = new ArrayList<>();
    private final PersonService testPersonService = new PersonService();

    @Test
    public void testGenerateCollectionWhenOneCommaIsMissing_TheExceptionIsThrown() {
        String line = "Luca Ionescu,28-09-1998";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> testPersonService.generateCollection(testPersonList, line));
    }

    @Test
    public void testGenerateCollectionWhenAnyAthleteFieldIsMissing_TheExceptionIsThrown() {
        String line = "Luca,28-09-1998";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> testPersonService.generateCollection(testPersonList, line));
    }

    @Test
    public void testDataFormat() {
        String str1 = "88-99-99999";
        String str2 = "28-09-1998";
        assertFalse(GenericValidator.isDate(str1, "dd-MM-yyyy", true));
        assertTrue(GenericValidator.isDate(str2, "dd-MM-yyyy", true));
    }

    @Test
    public void testOutputWhenResultIsNull() throws IOException {
        String line1 = "Grigore,Popovici,01-06-2002";
        String line2 = "Alexandra,Popescu,12-10-2000";
        String line3 = "Maria,Anton,23-04-2001";
        List<String> stringList = Arrays.asList(line1, line2, line3);
        for (String elem : stringList) {
            testPersonService.generateCollection(testPersonList, elem);
        }
        testPersonService.writeFile(testPersonList, "src/files/real_file/week9/output.txt");
        BufferedReader reader = new BufferedReader(new FileReader("src/files/real_file/week9/output.txt"));
        String expectedOutput = "null";
        String actualOutput = reader.readLine();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testOutputWhenResultIsNotNull() throws IOException {
        String line1 = "Grigore,Popovici,01-06-2002";
        String line2 = "Alexandra,Popescu,12-10-2000";
        String line3 = "Maria,Anton,23-04-2001";
        String line4 = "Luca,Ionescu,28-09-1998";
        String line5 = "Teodora,Florea,29-09-1999";
        List<String> stringList = Arrays.asList(line1, line2, line3, line4, line5);
        for (String elem : stringList) {
            testPersonService.generateCollection(testPersonList, elem);
        }
        testPersonService.writeFile(testPersonList, "src/files/real_file/week9/output.txt");
        BufferedReader reader = new BufferedReader(new FileReader("src/files/real_file/week9/output.txt"));
        List<String> ourOutputList = Arrays.asList("Teodora Florea", "Luca Ionescu");
        for (String elem : ourOutputList) {
            assertEquals(elem, reader.readLine());
        }
    }
}