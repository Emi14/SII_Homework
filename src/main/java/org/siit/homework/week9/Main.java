package org.siit.homework.week9;

import org.siit.homework.week9.model.Person;
import org.siit.homework.week9.service.PersonService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is the main class for week 9 homework");
        System.out.println();
        List<Person> personList = new ArrayList<>();
        String input = "src/files/real_file/week9/data.csv";
        String output = "src/files/real_file/week9/output.txt";
        PersonService personService = new PersonService();
        personService.readFile(personList, input);
        personList.forEach(System.out::println);
        personService.writeFile(personList, output);
    }
}
