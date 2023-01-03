package org.siit.homework.week8;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;
import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Athlete {
    private int number;
    private String name;
    private CountryCodes countryCode;
    private String raceTime;
    private List<String> shootingResults;
    private int missedShots;
    private String totalRaceTime;
    private Duration duration;
}
