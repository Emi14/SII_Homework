package org.siit.homework.hw8Tema9;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PersonFilter {
    public void processBirthdays(String inputFileName, int indicatedMonth, String outputFileName) {
        List<Person> aList = readFile(inputFileName);

        List<Person> personList = aList.stream()
                .filter(p -> p.getDateOfBirth().getMonthValue() == indicatedMonth)
                .sorted((p1, p2) -> {
                    if (p1.getFirstName().compareTo(p2.getFirstName()) != 0) {
                        return p1.getFirstName().compareTo(p2.getFirstName());
                    } else {
                        return p1.getLastName().compareTo(p2.getLastName());
                    }
                })
                .collect(Collectors.toList());
        writeFile(personList, outputFileName);
    }

    public void writeFile(List<Person> processedList, String outputFile) {

        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            for (Person p : processedList) {
                fileWriter.write(p.getFirstName() + " " + p.getLastName() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

    }

    public List<Person> readFile(String path) {
        List<Person> aList = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(path))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] s = line.split(",");
                Person person = new Person(s[0], s[1], LocalDate.parse(s[2]));
                aList.add(person);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return aList;
    }
}
