package org.siit.homework.week8;

import org.siit.homework.week8.comparator.SortByDuration;
import org.siit.homework.week8.model.Athlete;
import org.siit.homework.week8.service.LadderBoard;
import org.siit.homework.week8.service.LadderBoardService;

import java.io.FileNotFoundException;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This is the main class for week 8 homework");
        System.out.println();
        Set<Athlete> athleteSet = new TreeSet<>(new SortByDuration());
        String input = "src/files/real_file/athletes.csv";
        String output = "src/files/real_file/results.out";
        LadderBoardService ladderBoard = new LadderBoard();
        ladderBoard.readFile(athleteSet, input);
        athleteSet.forEach(System.out::println);
        System.out.println();
        ladderBoard.writeResults(athleteSet, output);
    }
}
