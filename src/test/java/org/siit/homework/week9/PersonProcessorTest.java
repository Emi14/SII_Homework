package org.siit.homework.week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonProcessorTest {

    @Test
    public void testProcessData() {
        String inputFile = "src/main/resources/ListPersonWeek9.csv";
        String outputFile = "src/main/resources/ListPersonWeek9-Output.csv";
        int month = 11;

        PersonProcessor processor = new PersonProcessor();
        processor.processData(inputFile, month, outputFile);

        List<String> outputFileContent = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(outputFile))) {
            while (scanner.hasNext()) {
                outputFileContent.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(5, outputFileContent.size());
        Assertions.assertEquals("Jimmy Black", outputFileContent.get(0));

    }

    @Test
    public void testProcessDataWrongInputFile() {
        String inputFile = "src/main/resources/ListPersonWeek9-WRONG.csv";
        String outputFile = "src/main/resources/ListPersonWeek9-Output.csv";
        int month = 11;

        PersonProcessor processor = new PersonProcessor();
        processor.processData(inputFile, month, outputFile);

        List<String> outputFileContent = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(outputFile))) {
            while (scanner.hasNext()) {
                outputFileContent.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(0, outputFileContent.size());

    }

}
