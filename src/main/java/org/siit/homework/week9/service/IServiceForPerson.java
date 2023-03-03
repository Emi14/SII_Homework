package org.siit.homework.week9.service;

import org.siit.homework.week9.model.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Month;
import java.util.List;

public interface IServiceForPerson {

    List<String> readInputFile(String INPUT_FILE_PATH);
    List<Person> splitListLines(List<String> inputLinesList);

    List<Person> manipulateData(List<Person> people, int targetMonth);
    void writeOutput(List<Person> orderedPeople,String OUTPUT_FILE_PATH);
}
