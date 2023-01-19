package week8;

import org.junit.jupiter.api.Test;
import org.siit.homework.week8.comparator.SortByDuration;
import org.siit.homework.week8.enums.CountryCode;
import org.siit.homework.week8.model.Athlete;
import org.siit.homework.week8.service.LadderBoard;
import org.siit.homework.week8.service.LadderBoardService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class LadderBoardTest {
    private final Set<Athlete> testAthleteSet = new TreeSet<>(new SortByDuration());
    private final LadderBoardService testLadderBoard = new LadderBoard();

    @Test
    public void testGenerateCollectionWhenOneCommaIsMissing_TheExceptionIsThrown() {
        String line = "7,Luca Ionescu RO,29:15,xxxxx,xxxxx,xxxxx";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> testLadderBoard.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollectionWhenAnyAthleteFieldIsMissing_TheExceptionIsThrown() {
        String line = "7,Luca Ionescu,RO,29:15,xxxxx,xxxxx";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> testLadderBoard.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollectionWhenRaceTimeIsNotSplitByColon_TheExceptionIsThrown() {
        String line = "7,Luca Ionescu,RO,29?15,xxxxx,xxxxx,xxxxx";
        assertThrows(NumberFormatException.class, () -> testLadderBoard.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollectionWhenShootingResultsAreNotExactlyFiveCharLong_TheExceptionIsThrown() {
        String line = "7,Luca Ionescu,RO,29:15,xxxxx,xxoxxx,xxxxx";
        assertThrows(IllegalArgumentException.class, () -> testLadderBoard.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollectionWhenCountryCodeDoesNotExist_TheExceptionIsThrown() {
        String line = "7,Luca Ionescu,ZZ,29:15,xxxxx,xxxxx,xxxxx";
        assertThrows(IllegalArgumentException.class, () -> testLadderBoard.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollectionWhenInputLineIsGood_TheAthleteAddedToSet() {
        List<String> testShootingResults = Arrays.asList("xxxxx", "xxxxx", "xxxxx");
        Duration testDuration = Duration.ofMinutes(29).plusSeconds(15);
        Athlete testAthlete = new Athlete(7, "Luca Ionescu", CountryCode.RO, "29:15", testShootingResults, 0, "29:15", testDuration);
        String line = "7,Luca Ionescu,RO,29:15,xxxxx,xxxxx,xxxxx";
        testLadderBoard.generateCollection(testAthleteSet, line);
        for (Athlete athlete : testAthleteSet) {
            assertEquals(athlete.getNumber(), testAthlete.getNumber());
            assertEquals(athlete.getName(), testAthlete.getName());
            assertEquals(athlete.getCountryCode(), testAthlete.getCountryCode());
            assertEquals(athlete.getRaceTime(), testAthlete.getRaceTime());
            assertEquals(athlete.getMissedShots(), testAthlete.getMissedShots());
            assertEquals(athlete.getTotalRaceTime(), testAthlete.getTotalRaceTime());
            assertEquals(athlete.getDuration(), testAthlete.getDuration());
            assertEquals(athlete.getShootingResults().size(), testShootingResults.size());
            List<String> shootingResults = athlete.getShootingResults();
            for (int i = 0; i < shootingResults.size(); ++i) {
                assertEquals(shootingResults.get(i), testShootingResults.get(i));
            }
        }
    }

    @Test
    public void testOutput() throws IOException {
        String line1 = "7,Luca Ionescu,RO,29:15,xxxxx,xxxxx,xxxxx";
        String line2 = "9,Paolo Montessori,IT,29:45,xxxxx,xxxxx,xxxxo";
        String line3 = "10,Claude Evra,FR,29:10,xxxxx,xxxxx,xoooo";
        testLadderBoard.generateCollection(testAthleteSet, line1);
        testLadderBoard.generateCollection(testAthleteSet, line2);
        testLadderBoard.generateCollection(testAthleteSet, line3);
        testLadderBoard.writeResults(testAthleteSet, "src/files/real_file/results.out");
        BufferedReader reader = new BufferedReader(new FileReader("src/files/real_file/week8/results.out"));
        String testLine = "Winner - Luca Ionescu 29:15 (29:15 + 0)";
        assertEquals(testLine, reader.readLine());
        testLine = "Runner-up - Claude Evra 29:50 (29:10 + 40)";
        assertEquals(testLine, reader.readLine());
        testLine = "Third Place - Paolo Montessori 29:55 (29:45 + 10)";
        assertEquals(testLine, reader.readLine());
    }
}