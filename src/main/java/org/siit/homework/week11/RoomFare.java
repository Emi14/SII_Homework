package org.siit.homework.week11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RoomFare {
    private int id;
    private double value;
    private String season;

    public RoomFare(double value, String season) {
        this.id = Integer.parseInt(UUID.randomUUID().toString());
        this.value = value;
        this.season = season;
    }

    //    public RoomFare(double value, String season) {
//        this.value = value;
//        this.season = season;
//    }
}