package org.siit.homework.hw8Tema9;

public class Main {
    public static void main(String[] args) {

        String inputFile = "src/main/resources/PersonList.csv";
        String outputFile = "src/main/resources/PersonList-Output.csv";
        int month = 4;

        PersonFilter processor = new PersonFilter();
        processor.processBirthdays(inputFile, month, outputFile);
        System.out.println("Check output file at: src/main/resources/PersonList-Output.csv");
    }
}
