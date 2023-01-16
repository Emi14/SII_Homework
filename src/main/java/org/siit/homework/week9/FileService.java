package org.siit.homework.week9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class FileService implements FileIterface
{

    List<Person> people = new ArrayList<>();

    @Override
    public void readFromFile(File reader)
    {
        try {
            Scanner myReader = new Scanner(reader);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] thisPerson = (data.split(" "));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.parse(thisPerson[2], formatter);
                people.add(new Person(thisPerson[0], thisPerson[1], localDate));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    @Override
    public void writeInFile(FileWriter writer)
    {
        try {
            List<String> personStreamNames = people.stream()
                    .filter(person -> person.getBirthDate().getMonthValue() == 5)
                    .sorted(Comparator.comparing(Person::getFirstName))
                    .map(person -> {
                        return person.firstName + " " + person.latName;
                    })
                    .collect(Collectors.toList());
            writer.write(Objects.requireNonNull(personStreamNames).toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
