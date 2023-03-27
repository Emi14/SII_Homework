package org.siit.homework.week9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        // Input parameters
        String inputFilePath = "src/main/resources/week9/inputNames.csv";
        String outputFilePath = "src/main/resources/week9/filteredNames.csv";
        int targetMonth = 07; // July

        // Read input CSV file into a list of Person objects
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Person> people = reader.lines()
                    .map(line -> {
                    String[] fields = line.split(",");
                    String firstName = fields[0].trim();
                    String lastName = fields[1].trim();
                    LocalDate birthDate = LocalDate.parse(fields[2].trim(), formatter);
                    return new Person(firstName, lastName, birthDate);
                })
                .collect(Collectors.toList());
        reader.close();

        // Filter and sort people by birth month and name
        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getDateOfBirth().getMonthValue() == targetMonth)
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());

        // Write output CSV file with just first and last name
        FileWriter writer = new FileWriter(outputFilePath);
        writer.write("First Name,Last Name\n");
        for (Person person : filteredPeople) {
            writer.write(String.format("%s,%s\n", person.getFirstName(), person.getLastName()));
        }
        writer.close();
    }
}
