package org.siit.homework.hw6Tema7.exception;

public class FirstNameException extends RuntimeException {
    private static final String MESSAGE = "First Name should not be empty.";

    public FirstNameException() {
        super(MESSAGE);
    }

}
