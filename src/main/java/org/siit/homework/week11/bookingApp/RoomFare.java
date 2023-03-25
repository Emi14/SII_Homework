package org.siit.homework.week11.bookingApp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomFare {

    private int id;
    private double valueEur;
    private String season;
}
