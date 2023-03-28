package org.siit.homework.week11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationRoomFare {
    private int accommodationId;
    private String accommodationType;
    private double roomFareValue;
    private String roomFareSeason;
}