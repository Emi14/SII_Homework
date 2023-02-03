package org.siit.homework.week9;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
    //    String inputFile = args[0];
        Integer targetMonth = 5;
     //   String outputFile = args[2];

        // Read data from input file
        List<Person1> people = readDataFromFile("C:\\Users\\Razvan\\Documents\\GitHub\\SIIT_Homework\\src\\main\\java\\org\\siit\\homework\\week9\\input_tema8_week9.txt");

        // Filter by birthday month and sort by surname and name
        // Sort by surname and name
        List<Person1> filteredPeople = people.stream()
                .filter(p -> p.getDob().getMonthValue() == targetMonth)
                .sorted(new PersonSurnameNameComparator())
                .collect(Collectors.toList());

        System.out.println(filteredPeople);

        // Write filtered data to output file
        writeDataToFile(filteredPeople, "C:\\Users\\Razvan\\Documents\\GitHub\\SIIT_Homework\\src\\main\\java\\org\\siit\\homework\\week9\\output_tema8_week9.txt");
    }

    private static List<Person1> readDataFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.lines()
                    .map(line -> {
                        String[] parts = line.split(",");
                        String surname = parts[0].trim();
                        String name = parts[1].trim();
                        LocalDate dob = LocalDate.parse(parts[2].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        System.out.println(dob);
                        return new Person1(surname, name, dob);
                    })
                    .collect(Collectors.toList());


        }

    }

    private static void writeDataToFile(List<Person1> people, String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Person1 person : people) {
                bw.write(person.getSurname() + "," + person.getName());
                bw.newLine();
            }
        }
    }
}
