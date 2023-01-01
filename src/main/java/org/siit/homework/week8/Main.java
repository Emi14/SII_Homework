package org.siit.homework.week8;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx\n";
        // parse the CSV file and create a list of BiathlonAthlete objects
        List<BiathlonAthlete> athletes = BiathlonStandings.parseCsv(csv);
        // calculate the final time for each athlete
        BiathlonStandings.calculateStandings(athletes);
        // sort the list by final time in ascending order
        Collections.sort(athletes, new BiathlonAthleteComparator());
        // print the final standings
        for (int i = 0; i < athletes.size(); i++) {
            BiathlonAthlete athlete = athletes.get(i);
            System.out.println((i+1) + " - " + athlete.getAthleteName() + " " + athlete.getFinalTime());
        }
    }
}