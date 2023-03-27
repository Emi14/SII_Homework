package homework.week8;

import org.junit.jupiter.api.Test;
import org.siit.homework.week8.athlete.Athlete;
import org.siit.homework.week8.comparator.ComparatorByDuration;
import org.siit.homework.week8.enums.CountryCode;
import org.siit.homework.week8.services.LadderBoardService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderBoardServiceTest {

    private final Set<Athlete> testAthleteSet = new TreeSet<>(new ComparatorByDuration());

    @Test
    public void testGenerateCollection_whenOneCommaIsMissing_theExceptionIsThrown() {
        String line = "1,Ionut Dragan RO,33:25,xxxxo,xxoxx,xxxxo";
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> LadderBoardService.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollection_whenAnyAthleteFieldIsMissing_theExceptionIsThrown() {
        Set<Athlete> testAthleteSet = new TreeSet<>(new ComparatorByDuration());
        String line = "1,Ionut Dragan RO,33:25,xxxxo,xxoxx,xxxxo";
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> LadderBoardService.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollection_whenShootingResultsAreNotExactlyFiveCharLong_theExceptionIsThrown() {
        String line = "1,Ionut Dragan RO,33:25,xxxxo,xxoxx,xxxxo";
        assertThrows(IllegalArgumentException.class,
                () -> LadderBoardService.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollection_whenRaceTimeIsNotSplitByColon_theExceptionIsThrown() {
        String line = "1,Ionut Dragan RO,33:25,xxxxo,xxoxx,xxxxo";
        assertThrows(NumberFormatException.class,
                () -> LadderBoardService.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollection_whenCountryCodeDoesNotExist_theExceptionIsThrown() {
        String line = "1,Ionut Dragan RO,33:25,xxxxo,xxoxx,xxxxo";
        assertThrows(IllegalArgumentException.class,
                () -> LadderBoardService.generateCollection(testAthleteSet, line));
    }

    @Test
    public void testGenerateCollection_whenInputLineISGood_theAthleteAddedToTheSet() {
        String[] testShootingResults = {"xxoxx", "xxxxx", "xxxxo"};
        Duration testDuration = Duration.ofMinutes(35).plusSeconds(37);
        Athlete testAthlete = new Athlete(
                1, "Cirebea Felix", CountryCode.RO, "35:17",
                testShootingResults, 2, "35:37", testDuration);
        String line = "1,Ionut Dragan RO,33:25,xxxxo,xxoxx,xxxxo";
        LadderBoardService.generateCollection(testAthleteSet, line);
        for (Athlete athlete : testAthleteSet) {
            assertEquals(athlete.getNumber(), testAthlete.getNumber());
            assertEquals(athlete.getName(), testAthlete.getName());
            assertEquals(athlete.getCountry(), testAthlete.getCountry());
            assertEquals(athlete.getRaceTime(), testAthlete.getRaceTime());
            assertEquals(athlete.getMissedShots(), testAthlete.getMissedShots());
            assertEquals(athlete.getTotalRaceTime(), testAthlete.getTotalRaceTime());
            assertEquals(athlete.getDuration(), testAthlete.getDuration());

            assertEquals(athlete.getShootingResults().length, testShootingResults.length);
            String[] shootingResults = athlete.getShootingResults();
            for (int i = 0; i < shootingResults.length; i++) {
                assertEquals(shootingResults[i], testShootingResults[i]);
            }
        }
    }

    @Test
    public void testWriteResults() throws IOException {
        String line1 = "1,Ionut Ionescu,RO,35:17,xxoxx,xxxxx,xxxxo";
        String line2 = "2,Marian Arpasanu,DK,34:49,xxxxx,xooxx,oxxxo";
        String line3 = "3,Vlad Motran,MC,35:00,xxoxx,xxoxx,xxxox";
        LadderBoardService.generateCollection(testAthleteSet, line1);
        LadderBoardService.generateCollection(testAthleteSet, line2);
        LadderBoardService.generateCollection(testAthleteSet, line3);
        LadderBoardService.writeResults(testAthleteSet);
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/results.txt"));
        String testLine = "Winner - Marian Arpasanu 35:29 (34:49 + 4)";
        String readLine = reader.readLine();
        assertEquals(testLine, readLine);
        testLine = "Runner-up - Vlad Motran 35:30 (35:00 + 3)";
        readLine = reader.readLine();
        assertEquals(testLine, readLine);
        testLine = "Third Place - Ionut Ionescu 35:37 (35:17 + 2)";
        readLine = reader.readLine();
        assertEquals(testLine, readLine);
        reader.close();
    }

}