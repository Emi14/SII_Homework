package org.siit.homework.week7.enums;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender fromString(String genderStr) {
        switch (genderStr.toUpperCase()) {
            case "M":
            case "MALE":
                return MALE;
            case "F":
            case "FEMALE":
                return FEMALE;
            default:
                throw new IllegalArgumentException("Invalid gender: " + genderStr);
        }
    }
}
