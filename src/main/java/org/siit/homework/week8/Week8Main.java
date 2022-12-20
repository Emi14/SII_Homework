package org.siit.homework.week8;

import org.siit.homework.week8.comparator.ComparatorByDuration;

import java.util.Set;
import java.util.TreeSet;

import static org.siit.homework.week8.LadderBoardService.readFile;
import static org.siit.homework.week8.LadderBoardService.writeResults;

public class Week8Main {
    public static void main(String[] args) {

        Set<Athlete> athleteSet = new TreeSet<>(new ComparatorByDuration());
        String filePath = "src/main/resources/input.csv";
        readFile(athleteSet, filePath);

        for (Athlete athlete : athleteSet) {
            System.out.println(athlete);
        }
        System.out.println();

        writeResults(athleteSet);

    }
}
