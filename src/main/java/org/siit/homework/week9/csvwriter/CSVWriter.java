package org.siit.homework.week9.csvwriter;

import org.siit.homework.week9.person.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CSVWriter {
    private final File csvFile;
    private final String csvDelimiter;

    public CSVWriter(String csvFilePath, String csvDelimiter) {
        this.csvFile = new File(csvFilePath);
        this.csvDelimiter = csvDelimiter;
    }

    public void writeCSVFile(List<Person> persons, Month month) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            List<Person> filteredPersons = persons.stream()
                    .filter(person -> person.getDateOfBirth().getMonth() == month)
                    .sorted(Comparator.comparing(Person::getLastName))
                    .collect(Collectors.toList());

            for (Person person : filteredPersons) {
                String line = person.getFirstName() + csvDelimiter + person.getLastName();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
