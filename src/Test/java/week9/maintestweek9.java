package week9;

import org.junit.Test;
import org.siit.homework.week9.Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class maintestweek9 {

    private static final String INPUT_FILE = "C:\\Users\\Razvan\\Documents\\GitHub\\SIIT_Homework\\src\\main\\java\\org\\siit\\homework\\week9\\input_tema8_week9.txt";
    private static final String OUTPUT_FILE = "C:\\Users\\Razvan\\Documents\\GitHub\\SIIT_Homework\\src\\main\\java\\org\\siit\\homework\\week9\\output_tema8_week9.txt";

    @Test
    public void testFilterAndSort() throws IOException {
        // Prepare test data
        String inputData = "Enescu,George,01/01/1950\nEminescu,Mihai,03/02/1987\nPruteanu,George,04/05/2001\nDima,Mihai,02/06/1977\n";
        Files.write(Paths.get(INPUT_FILE), inputData.getBytes());

        // Run the application
        Main.main(new String[] { INPUT_FILE, "1", OUTPUT_FILE });

        // Read output data
        List<String> outputLines = Files.readAllLines(Paths.get(OUTPUT_FILE));
        String[] outputData = outputLines.toArray(new String[0]);

        // Verify output data
        assertArrayEquals(new String[] { "Dima,Mihai", "Eminescu,Mihai" }, outputData);
    }
}
