package org.siit.homework.week7.algorithm;

import java.time.LocalDate;
import java.time.Period;

public class Algorithm {
    public int calculateAge(LocalDate date1, LocalDate date2) {
        return (date1 == null || date2 == null) ? 0 : Period.between(date1, date2).getYears();
    }

    public boolean isBetween(int toCheck, int from, int to) {
        return from <= toCheck && to >= toCheck;
    }

    public boolean isNumber(String value) {
        for (char elem : value.toCharArray()) {
            if (!Character.isDigit(elem)) {
                return false;
            }
        }
        return true;
    }
}
