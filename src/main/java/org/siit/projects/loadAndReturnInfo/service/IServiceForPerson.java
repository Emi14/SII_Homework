package org.siit.projects.loadAndReturnInfo.service;

import org.siit.projects.loadAndReturnInfo.model.Person;

import java.util.List;

public interface IServiceForPerson {

    List<String> readInputFile(String INPUT_FILE_PATH);
    List<Person> splitListLines(List<String> inputLinesList);

    List<Person> manipulateData(List<Person> people, int targetMonth);
    void writeOutput(List<Person> orderedPeople,String OUTPUT_FILE_PATH);
}
