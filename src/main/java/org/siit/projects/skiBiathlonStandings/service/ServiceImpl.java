package org.siit.projects.skiBiathlonStandings.service;

import org.siit.projects.skiBiathlonStandings.comparator.AthleteComparatorByFinalRaceTime;
import org.siit.projects.skiBiathlonStandings.model.Athlete;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class ServiceImpl implements IService {


    @Override
    public List<Athlete> determineStandings(String fileName){
        List<Athlete> athletList = parseCSV(fileName);
        determineFinalStandings(athletList);
        return athletList;
    }
    List<Athlete> parseCSV(String fileName) {
        List<Athlete> athleteList = new ArrayList<>();

        try(Scanner scanner = new Scanner(Paths.get(fileName))){
            while(scanner.hasNext()){
                generateCollection(athleteList, scanner);
            }
            return athleteList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void generateCollection(List<Athlete> athleteList, Scanner scanner) {
        String line = scanner.nextLine();
        String[] columns = line.split(",");
        int athleteNumber = Integer.parseInt(columns[0]);
        String athleteName = columns[1];
        String countryCodes = columns[2];
        String raceTime = columns[3];
        List<String> shootingResults = new ArrayList<>();
        shootingResults.add(columns[4]);
        shootingResults.add(columns[5]);
        shootingResults.add(columns[6]);
        athleteList.add(new Athlete(athleteNumber, athleteName, countryCodes, raceTime, shootingResults));
    }

    private void determineFinalStandings(List<Athlete> athleteList) {
        athleteList.sort(new AthleteComparatorByFinalRaceTime());
    }
    public List<String> writeResults() {
        List<String> places = new ArrayList<>();
        places.add(0, "Winner");
        places.add(1, "Runner-up");
        places.add(2, "Third place");

        return places;
    }
}
