package org.siit.homework.week9;

public class Main {
//
//   --> By using streams and lambda expressions, implement a small application which:
//         - load from a file a structure like first name, last name, date of birth
//         - write back another file containing only first name, last name ordered alphabetically
//         for all the matches which have the birthday on an indicated month
//         - application takes 3 parameters
//                    input filename
//                    target month (1 - 12)
//                    output file name
//
    public static void main(String[] args) {

        String inputFile = "src/main/resources/ListPersonWeek9.csv";
        String outputFile = "src/main/resources/ListPersonWeek9-Output.csv";
        int month = 11;

        PersonProcessor processor = new PersonProcessor();
        processor.processData(inputFile, month, outputFile);
        System.out.println("\nPlease check in the folder: 'src/main/resources' the Output csv file, containing the matches which have the birthday on the indicated month. ");
    }

    ////// TESTS AVAILABLE. PLEASE CHECK HERE: src/test/java/org/siit/homework/week9 //////

}
