package week8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.siit.homework.week8.Athlete;
import org.siit.homework.week8.ISOCountryCode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class BiathlonTest {
    @Test
    public void testStandingCalculation() {
        Athlete athlete1 = new Athlete(11, "Umar Jorgson", ISOCountryCode.SK, "30:27",
                new String[]{"xxxox", "xxxxx", "xxoxo"});
        Athlete athlete2 = new Athlete(1, "Jimmy Smiles", ISOCountryCode.UK, "29:15",
                new String[]{"xxoox", "xooxo", "xxxxo"});
        Athlete athlete3 = new Athlete(27, "Piotr Smitzer", ISOCountryCode.CZ, "30:10",
                new String[]{"xxxxx", "xxxxx", "xxxxx"});
        List<Athlete> athletes = Arrays.asList(athlete1, athlete2, athlete3);
        athletes.forEach(Athlete::calculateTotalTime);
        List<Athlete> sortedAthletes = athletes.stream()
                .sorted(Comparator.comparing(Athlete::getTotalTime))
                .collect(Collectors.toList());
        Assertions.assertEquals("Piotr Smitzer 30:10 (30:10 + 0)", sortedAthletes.get(0).toString());
        Assertions.assertEquals("Jimmy Smiles 30:15 (29:15 + 60)", sortedAthletes.get(1).toString());
        Assertions.assertEquals("Umar Jorgson 30:57 (30:27 + 30)", sortedAthletes.get(2).toString());
    }
}
