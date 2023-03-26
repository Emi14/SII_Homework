package org.siit.homework.week11.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "accommodation")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`TYPE`", nullable = false, length = 32)
    private String type;

    @Column(name = "bed_type", nullable = false, length = 32)
    private String bedType;

    @Column(name = "max_guests", nullable = false)
    private Integer maxGuests;

    @Column(name = "`description`", length = 512)
    private String description;
}