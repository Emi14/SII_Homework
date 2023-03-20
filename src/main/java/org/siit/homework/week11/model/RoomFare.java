package org.siit.homework.week11.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomFare {

    private int id;
    private double value;
    private String season;

}
