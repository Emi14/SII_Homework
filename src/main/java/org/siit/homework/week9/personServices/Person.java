package org.siit.homework.week9.personServices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

    @Data
    @Builder
    @AllArgsConstructor
    public class Person {

        String firstName;
        String lastName;
        LocalDate dateOfBirth;

    }
