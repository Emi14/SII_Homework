package org.siit.projects.jdbcBookingApp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomFare {

    private int id;
    private double value;
    private String season;

}
