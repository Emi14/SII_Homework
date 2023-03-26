package org.siit.homework.week8.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public String readCsv(String filePath) throws IOException {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
