package org.siit.homework.week9;

import org.siit.homework.week9.csvreader.CSVReader;
import org.siit.homework.week9.csvwriter.CSVWriter;
import org.siit.homework.week9.person.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("This is the main class for week 9 homework");
        System.out.println();

        try {

            DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            String csvFilePath = "src/main/resources/week9/inputcsv/NamesAndBirthdayDates.csv";
            CSVReader csvReader = new CSVReader(csvFilePath, ",", DATE_FORMAT);
            List<Person> persons = csvReader.readCSVFile();

            for (Person person : persons) {
                System.out.println("Full Name: " + person.getFirstName() + " " + person.getLastName());
                System.out.println("Date of Birth: " + person.getDateOfBirth());
                System.out.println();
            }

            String outputCsvFilePath = "src/main/resources/week9/outputcsv/PersonsOrderedAlphabeticallyFilteredByMonth.csv";
            CSVWriter csvWriter = new CSVWriter(outputCsvFilePath, ",");
            csvWriter.writeCSVFile(persons, Month.MARCH);
            System.out.println("PersonsOrderedAlphabeticallyFilteredByMonth csv file has been updated");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
