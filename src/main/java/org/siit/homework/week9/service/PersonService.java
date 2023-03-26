package org.siit.homework.week9.service;

import org.siit.homework.week9.exception.InvalidDateException;
import org.siit.homework.week9.model.Person;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

import static org.apache.commons.validator.GenericValidator.isDate;

public class PersonService {
    public void readFile(List<Person> personList, String input) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                generateCollection(personList, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateCollection(List<Person> personList, String line) {
        String[] split = line.split(",");
        personList.add(new Person(split[0], split[1], stringToLocalDate(split[2])));
    }

    public LocalDate stringToLocalDate(String dateString) {
        String dateFormat = "dd-MM-yyyy";
        if (!isDate(dateString, dateFormat, true)) {
            throw new InvalidDateException("Unknown date format: " + dateString);
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDate.parse(dateString, dateTimeFormatter);
    }

    public void writeFile(List<Person> personList, String output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            if (personList.isEmpty()) {
                writer.write("null");
                return;
            }
            StringBuilder builder = new StringBuilder();
            List<Person> personList1 = personList
                    .stream()
                    .filter(person -> person.getBirthDate().getMonthValue() == 9)
                    .sorted(Comparator.comparing(Person::getLastName))
                    .toList();
            if (personList1.isEmpty()) {
                writer.write("null");
            } else {
                for (Person person : personList1) {
                    builder.append(person.getFirstName())
                            .append(' ').append(person.getLastName())
                            .append('\n');
                }
                writer.write(builder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
