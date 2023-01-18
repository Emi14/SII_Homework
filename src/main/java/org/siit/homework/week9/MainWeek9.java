package org.siit.homework.week9;

import org.siit.homework.week9.personServices.IPersonService;
import org.siit.homework.week9.personServices.Person;
import org.siit.homework.week9.personServices.PersonServiceCls;

import java.util.List;

public class MainWeek9 {

    public static final IPersonService personService = new PersonServiceCls();
    public static final String INPUT_FILE_PATH = "src/main/resources/week9input.csv";
    public static final String OUTPUT_FILE_PATH = "src/main/resources/week9output.out";

    public static void main(String[] args) {

        List<Person> personList = personService.readInput(INPUT_FILE_PATH);
        personList = personService.manipulateData(personList, 10);
        personService.writeOutput(personList, OUTPUT_FILE_PATH);

    }
}
