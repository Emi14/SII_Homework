package org.siit.homework.hw8Tema9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class PersonFilterTest {

    private static final String INPUT_FILE_PATH = "src/test/resources/PersonListTest.csv";
    private static final String OUTPUT_FILE_PATH = "src/test/resources/PersonList-Output-Test.csv";

    @Test
    void processBirthdays_shouldFilterAndSortPersonsByMonthAndName() throws IOException {
        // Given
        PersonFilter filter = new PersonFilter();
        int month = 4;

        // When
        filter.processBirthdays(INPUT_FILE_PATH, month, OUTPUT_FILE_PATH);

        // Then
        File outputFile = new File(OUTPUT_FILE_PATH);
        Assertions.assertTrue(outputFile.exists(), "Output file should exist");

        List<String> expectedLines = Arrays.asList("Emil  Junko", "Geraldo  Meena", "Ozana  Tena");
        List<String> actualLines = Files.readAllLines(outputFile.toPath());
        Assertions.assertEquals(expectedLines, actualLines, "Output file should contain the expected lines");
    }

    @Test
    void processBirthdays_shouldHandleEmptyInputFile() throws IOException {
        // Given
        PersonFilter filter = new PersonFilter();
        int month = 4;

        // When
        filter.processBirthdays("src/test/resources/EmptyList.csv", month, OUTPUT_FILE_PATH);

        // Then
        File outputFile = new File(OUTPUT_FILE_PATH);
        Assertions.assertTrue(outputFile.exists(), "Output file should exist");

        List<String> actualLines = Files.readAllLines(outputFile.toPath());
        Assertions.assertTrue(actualLines.isEmpty(), "Output file should be empty");
    }

    @Test
    void processBirthdays_shouldHandleNonexistentInputFile() {
        // Given
        PersonFilter filter = new PersonFilter();
        int month = 4;
        String inputFile = "src/test/resources/NonexistentFile.csv";

        // When
        filter.processBirthdays(inputFile, month, OUTPUT_FILE_PATH);

        // Then
        File inputFileObj = new File(inputFile);
        Assertions.assertFalse(inputFileObj.exists(), "Output file should not exist");
    }

    @Test
    void processBirthdays_shouldHandleInvalidInputData() throws IOException {
        // Given
        PersonFilter filter = new PersonFilter();
        int month = 4;

        // When
        filter.processBirthdays("src/test/resources/InvalidList.csv", month, OUTPUT_FILE_PATH);

        // Then
        File outputFile = new File(OUTPUT_FILE_PATH);
        Assertions.assertTrue(outputFile.exists(), "Output file should exist");

        List<String> actualLines = Files.readAllLines(outputFile.toPath());
        Assertions.assertTrue(actualLines.isEmpty(), "Output file should be empty");
    }

}
