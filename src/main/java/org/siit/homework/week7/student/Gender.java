package org.siit.homework.week7.student;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender fromChar(char genderChar) {
        switch (Character.toUpperCase(genderChar)) {
            case 'M':
            case 'm':
                return MALE;
            case 'F':
            case 'f':
                return FEMALE;
            default:
                throw new IllegalArgumentException("Invalid gender.");
        }
    }
}
