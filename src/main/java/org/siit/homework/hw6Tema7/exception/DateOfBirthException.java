package org.siit.homework.hw6Tema7.exception;

public class DateOfBirthException extends RuntimeException {
    private static final String MESSAGE = "Date of birth between 1900 and current year - 18.";

    public DateOfBirthException() {
        super(MESSAGE);
    }

}
