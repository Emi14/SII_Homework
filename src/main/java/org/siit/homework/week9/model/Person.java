package org.siit.homework.week9.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@NonNull
public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
