package org.siit.homework.week11.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomFare {
    private int id;
    private double value;
    private String season;

    public RoomFare(double value, String season) {
        this.value = value;
        this.season = season;
    }
}
