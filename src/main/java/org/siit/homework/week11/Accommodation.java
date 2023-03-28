package org.siit.homework.week11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
public class Accommodation {
    private int id;
    private String type;
    private String bedType;
    private int maxGuests;
    private String description;

    public Accommodation(String type, String bedType, int maxGuests, String description) {
        this.id = Integer.parseInt(UUID.randomUUID().toString());
        this.type = type;
        this.bedType = bedType;
        this.maxGuests = maxGuests;
        this.description = description;
    }

    //    public Accommodation(String type, String bedType, int maxGuests, String description) {
//        this.type = type;
//        this.bedType = bedType;
//        this.maxGuests = maxGuests;
//        this.description = description;
//    }
}
