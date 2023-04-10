package org.siit.projects.jdbcBookingApp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccommodationRoomFareRelation {

    private String roomType;
    private String roomBedType;
    private double roomPrice;
    private String roomPriceSeason;

}
