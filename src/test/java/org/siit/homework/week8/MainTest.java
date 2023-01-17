package org.siit.homework.week8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTest {
    @Test
    public void testReadCSVFile() {
        String filePath = "src/main/resources/ListWeek8.csv";
        List<Athlete> testList = Main.readCSVFile(filePath);
        Assertions.assertEquals(11,testList.size());
    }

    @Test
    public void testReadCSVFileWrongPath() {
        String filePath = "src/main/resources/ListWRONG.csv";
        List<Athlete> testList = Main.readCSVFile(filePath);
        Assertions.assertEquals(0,testList.size());
    }


}
