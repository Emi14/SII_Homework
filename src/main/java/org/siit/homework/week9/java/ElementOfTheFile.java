package org.siit.homework.week9.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElementOfTheFile {

    public static List<String> read(String fileName) {
        List<String> fileS = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                fileS.add(scanner.nextLine());

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return fileS;
    }
    public String removeSpaces(String string) {
        char[] characters = string.toCharArray();
        String chars = "";

        while (characters[0] == ' ') {
            for (int i = 0; i < characters.length - 1; i++)
                characters[i] = characters[i + 1];
            characters[characters.length - 1] = '\0';
        }
        int i = 0;
        while (i<characters.length && characters[i] != '\0') {
            chars += characters[i];
            i++;
        }
        return chars;
    }
}