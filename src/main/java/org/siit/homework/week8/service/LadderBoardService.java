package org.siit.homework.week8.service;

import org.siit.homework.week8.model.Athlete;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public interface LadderBoardService {
    void readFile(Set<Athlete> athleteSet, String filePath) throws FileNotFoundException;
    void generateCollection(Set<Athlete> athleteSet, String line);
    int calculateMissedShots(List<String> shootingResults);
    Duration calculateTotalRaceTime(String raceTime, int missedShots);
    String durationToString(Duration duration);
    Duration stringToDuration(String time);
    void writeResults(Set<Athlete> athleteSet, String output);
}
