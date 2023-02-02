package org.siit.homework.week9.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        int month = 0;
        ElementOfTheFile elementOfTheFile = new ElementOfTheFile();
        List<String> lines = elementOfTheFile.read("src/main/resources/in.txt");
        List<Person> personList = new ArrayList<>();

        for (String line : lines) {
            List<String> elements = List.of(line.split(","));
            Person person = new Person();
            person.setFirstName(elementOfTheFile.removeSpaces(elements.get(0)));
            person.setLastName(elementOfTheFile.removeSpaces(elements.get(1)));

            DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
            Date date = (Date) formatter.parse(elementOfTheFile.removeSpaces(elements.get(2)));

            person.setDate(date);
            personList.add(person);
        }

        List<List<String>> firstNames = personList.stream()
                .filter(person -> {
            return person.getDate().getMonth() == month;
        }).sorted((o1,o2)-> o1.compareTo(o2))
                .map(person -> List.of(person.getFirstName(),person.getLastName())).toList();
        System.out.println(firstNames);

    }
}
