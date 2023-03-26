package org.siit.homework.week9;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.siit.homework.week9.csvreader.CSVReader;
import org.siit.homework.week9.person.Person;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {
    @SneakyThrows
    @Test
    public void readCSVFile_withValidFile_returnsCorrectData() {

        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String filePath = "src/main/resources/week9/inputcsv/NamesAndBirthdayDates.csv";
        CSVReader csvReader = new CSVReader(filePath, ",", DATE_FORMAT);

        List<Person> persons = csvReader.readCSVFile();

        assertTrue(persons.size() > 0);
        assertEquals("Albert", persons.get(0).getFirstName());
        assertEquals("Einstein", persons.get(0).getLastName());
        assertEquals(LocalDate.of(1879, 3, 14), persons.get(0).getDateOfBirth());
    }

    @Test
    public void readCSVFile_withInvalidFile_throwsFileNotFoundException() {
        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        CSVReader csvReader = new CSVReader("invalid/file/path.csv", ",", DATE_FORMAT);
        assertThrows(FileNotFoundException.class, csvReader::readCSVFile);
    }
}
