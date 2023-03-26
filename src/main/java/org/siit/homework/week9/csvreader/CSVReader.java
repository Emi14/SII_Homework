package org.siit.homework.week9.csvreader;

import org.siit.homework.week9.person.Person;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader {
    private final DateTimeFormatter dateFormat;
    private File csvFile;
    private final String csvSplitBy;
    private List<Person> persons;

    public CSVReader(String csvFilePath, String csvSplitBy, DateTimeFormatter dateFormat) {
        this.csvFile = new File(csvFilePath);
        this.csvSplitBy = csvSplitBy;
        this.dateFormat = dateFormat;
        this.persons = new ArrayList<>();
    }

    public List<Person> readCSVFile() throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            persons = br.lines()
                    .filter(line -> !line.isEmpty())
                    .filter(line -> line.split(csvSplitBy).length >= 3)
                    .map(line -> {
                        String[] values = line.split(csvSplitBy);
                        return new Person(values[0].trim(), values[1].trim(), LocalDate.parse(values[2].trim(), dateFormat));
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            if(e instanceof FileNotFoundException)
                throw (FileNotFoundException) e;
            else
                e.printStackTrace();
        }
        return persons;
    }
}
