package org.siit.homework.week8;

import org.siit.homework.week8.comparator.ComparatorByDuration;
import org.siit.homework.week8.service.LadderBoard;
import org.siit.homework.week8.service.LadderBoardService;

import java.io.FileNotFoundException;
import java.util.Set;
import java.util.TreeSet;

public class MainWeek8 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This is the main class for week 8 homework");

        Set<Athlete> athleteSet = new TreeSet<>(new ComparatorByDuration());
        String input = "src/main/resources/athletes.csv";
        String output = "src/main/resources/athletes.out";
        LadderBoardService ladderBoard = new LadderBoard();
        ladderBoard.readFile(athleteSet, input);
        athleteSet.forEach(System.out::println);
        System.out.println();
        ladderBoard.writeResults(athleteSet, output);
    }
}
