package org.siit.projects.loadAndReturnInfo.service;

import org.siit.projects.loadAndReturnInfo.model.Person;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceForPersonImpl implements IServiceForPerson{

    @Override
    public List<String> readInputFile(String inputFileName) {

        List<String> inputLinesList = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFileName))){
            String line = reader.readLine();
            while(line != null) {
                inputLinesList.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return inputLinesList;
    }

    @Override
    public List<Person> splitListLines(List<String> inputLinesList) {

        List<Person> people = new ArrayList<>();

        for(String line: inputLinesList) {
            String[] elements = line.split(",");
            String firstName = elements[0].trim();
            String lastName = elements[1].trim();
            LocalDate dateOfBirth = LocalDate.parse(elements[2].trim());

            Person person = new Person(firstName, lastName, dateOfBirth.getMonthValue());

            people.add(person);
        }
        return people;
    }

    public List<Person> manipulateData(List<Person> people, int targetMonth){

        return people.stream()
                .filter(person1 -> person1.getMonthOfBirth() == targetMonth)
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());

    }
    @Override
    public void writeOutput(List<Person> orderedPeople, String outputFileName) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))){

            for (Person person:orderedPeople){
                writer.write(person.getFirstName() + ", " + person.getLastName() + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }


}
