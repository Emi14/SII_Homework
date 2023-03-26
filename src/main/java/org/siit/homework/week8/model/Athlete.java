package org.siit.homework.week8.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.siit.homework.week8.enums.CountryCode;

import java.time.Duration;
import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Athlete {
    private int number;
    private String name;
    private CountryCode countryCode;
    private String raceTime; // race time without penalties
    private List<String> shootingResults;
    private int missedShots;
    private String totalRaceTime; // race time with penalties
    private Duration duration;
}
