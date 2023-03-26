package org.siit.homework.week11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "room_fare")
public class RoomFare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`value`", nullable = false)
    private Double value;

    @Column(name = "`season`", nullable = false, length = 32)
    private String season;
}
