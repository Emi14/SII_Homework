package org.siit.homework.week11.bookingApp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomPrice {

    private String roomType;
    private String roomBedType;
    private double roomPrice;
    private String roomPriceSeason;
}
