package org.siit.projects.jdbcBookingApp.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Accommodation {

    private int id;
    private String type;
    private String bedType;
    private int maxGuests;
    private String description;

}
