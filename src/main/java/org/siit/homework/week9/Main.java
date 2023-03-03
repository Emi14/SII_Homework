package org.siit.homework.week9;


import org.siit.homework.week9.model.Person;
import org.siit.homework.week9.service.IServiceForPerson;
import org.siit.homework.week9.service.ServiceForPersonImpl;

import java.util.List;

public class Main {
    public static final String INPUT_FILE_PATH = "src/main/resources/w9input.csv";
    public static final String OUTPUT_FILE_PATH = "src/main/resources/w9output.csv";
    public static final IServiceForPerson serviceForPerson = new ServiceForPersonImpl();
    public static void main(String[] args) {

       List<String> inputLinesList = serviceForPerson.readInputFile(INPUT_FILE_PATH);
       List<Person> people = serviceForPerson.splitListLines(inputLinesList);
       List<Person> orderedPeople = serviceForPerson.manipulateData(people, 6);
       serviceForPerson.writeOutput(orderedPeople, OUTPUT_FILE_PATH);

    }


}
