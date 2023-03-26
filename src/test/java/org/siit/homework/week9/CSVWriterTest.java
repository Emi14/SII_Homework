package org.siit.homework.week9;

import org.junit.jupiter.api.Test;
import org.siit.homework.week9.csvwriter.CSVWriter;
import org.siit.homework.week9.person.Person;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVWriterTest {
    @Test
    public void writeCSVFile_withValidData_createsCSVFile() throws IOException {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Albert", "Einstein", LocalDate.of(1879, 3, 14)));
        persons.add(new Person("Cantor", "Georg", LocalDate.of(1845, 3, 3)));
        persons.add(new Person("Descartes", "Rene", LocalDate.of(1596, 3, 31)));

        String filePath = "test.csv";
        CSVWriter csvWriter = new CSVWriter(filePath, ",");

        csvWriter.writeCSVFile(persons, Month.MARCH);

        File file = new File(filePath);
        assertTrue(file.exists());
        file.delete();
    }
}

