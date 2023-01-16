package org.siit.homework.week9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        List<Person> people = new ArrayList<>();
        FileIterface file = new FileService();

        File reader = new File("Person.In.txt");
        file.readFromFile(reader);

        FileWriter writer = new FileWriter("Person.Out.txt");
        file.writeInFile(writer);

    }
}
