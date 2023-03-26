package org.siit.homework.week11.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Accomodation {
    private int id;
    private String type;
    private String bedType;
    private int maxGuests;
    private String description;

    public Accomodation(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public Accomodation(int id, String type, String bedType, int maxGuests, String description) {
        this.id = id;
        this.type = type;
        this.bedType = bedType;
        this.maxGuests = maxGuests;
        this.description = description;
    }

    private List<RoomFare> fares = new ArrayList<>();

    public List<RoomFare> getFares() {
        return fares;
    }
}
