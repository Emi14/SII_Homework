package week8Test;

import org.junit.jupiter.api.Test;
import org.siit.homework.week8.Athlete;
import org.siit.homework.week8.CountryCodes;
import org.siit.homework.week8.comparator.ComparatorByDuration;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AthletesTest {

    private final Set<Athlete> testAthleteSet = new TreeSet<>(new ComparatorByDuration());
    private final LadderBoardService testLadderBoard = new LadderBoard();

    @Test
    public void testGenerateCollectionWhenOneCommaIsMissing_TheExceptionIsThrown() {
        String line = "7,David Popovici RO,29:14,xxxxx,xxxxx,xxxxx";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> testLadderBoard.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollectionWhenAnyAthleteFieldIsMissing_TheExceptionIsThrown() {
        String line = "7,David Popovici,RO,29:14,xxxxx,xxxxx";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> testLadderBoard.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollectionWhenRaceTimeIsNotSplitByColon_TheExceptionIsThrown() {
        String line = "7,David Popovici,RO,29?14,xxxxx,xxxxx,xxxxx";
        assertThrows(NumberFormatException.class, () -> testLadderBoard.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollectionWhenShootingResultsAreNotExactlyFiveCharLong_TheExceptionIsThrown() {
        String line = "7,David Popovici,RO,29:14,xxxxx,xxoxxx,xxxxx";
        assertThrows(IllegalArgumentException.class, () -> testLadderBoard.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollectionWhenCountryCodeDoesNotExist_TheExceptionIsThrown() {
        String line = "7,David Popovici,ZZ,29:14,xxxxx,xxxxx,xxxxx";
        assertThrows(IllegalArgumentException.class, () -> testLadderBoard.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollectionWhenInputLineIsGood_TheAthleteAddedToSet() {
        List<String> testShootingResults = Arrays.asList("xxxxx", "xxxxx", "xxxxx");
        Duration testDuration = Duration.ofMinutes(29).plusSeconds(14);
        Athlete testAthlete = new Athlete(7, "David Popovici", CountryCodes.RO, "29:14", testShootingResults, 0, "29:14", testDuration);
        String line = "7,David Popovici,RO,29:14,xxxxx,xxxxx,xxxxx";
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
        String line1 = "3,Stefano Gasparini,IT,28:30,xxxxo,oxxxx,xxxxx";
        String line2 = "7,David Popovici,RO,29:14,xxxxx,xxxxx,xxxxx";
        String line3 = "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";
        testLadderBoard.generateCollection(testAthleteSet, line1);
        testLadderBoard.generateCollection(testAthleteSet, line2);
        testLadderBoard.generateCollection(testAthleteSet, line3);
        testLadderBoard.writeResults(testAthleteSet, "src/main/resources/athletes.out");
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/athletes.out"));
        String testLine = "Winner - Stefano Gasparini 28:50 (28:30 + 20)";
        assertEquals(testLine, reader.readLine());
        testLine = "Runner-up - David Popovici 29:14 (29:14 + 0)";
        assertEquals(testLine, reader.readLine());
        testLine = "Third Place - Piotr Smitzer 30:10 (30:10 + 0)";
        assertEquals(testLine, reader.readLine());
    }
}
